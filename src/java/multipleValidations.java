
import Validator.MatlabControl;
import Validator.Validator;
import static Validator.Validator.compareFilesWithModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

@WebServlet(urlPatterns = {"/MultipleValidations"})
public class multipleValidations extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // IMPROVE: TRACTAR MILLOR NOMS LOGS
        if (request.getParameter("button1") != null) {
            MatlabControl mc = new MatlabControl();
            File[] files = new File(System.getProperty("user.dir") + "/solDirectory").listFiles();
            new File(System.getProperty("user.dir") + "/solFile/selectedFile/").mkdirs();
            File[] uploaded = new File(System.getProperty("user.dir") + "/solFile/selectedFile/").listFiles();
            File sL = new File(System.getProperty("user.dir") + "/solFile/solutionLogs");
            sL.mkdirs();
            cleanDirectory(sL);
            File[] solu = new File(System.getProperty("user.dir") + "/solFile/sol/").listFiles();
            File dir3 = new File(System.getProperty("user.dir") + "/solFile/finalDocuments");
            dir3.mkdir();
            cleanDirectory(dir3);
            final File[] logFiles = new File(System.getProperty("user.dir")
                    + "/solFile").listFiles(new FilenameFilter() {
                @Override
                public boolean accept(final File dir,
                        final String name) {
                    return name.matches("wlog.*\\.txt");
                }
            });
            for (final File fl : logFiles) {
                if (!fl.delete()) {
                    System.err.println("Can't remove " + fl.getAbsolutePath());
                }
            }
            int number_of_folders = files.length;
            int x;

            for (int i = 1; i < number_of_folders; i++) {
                String script = "" + uploaded[0];
                script = script.substring(0, script.length() - 2);
                ArrayList<File> files_from_directory = new ArrayList();
                System.out.println("Path: " + files[i].getPath() + " Number of folders: " + number_of_folders
                        + " i: " + i);
                listf(files[i].getPath(), files_from_directory);
                System.out.println("La i es: " + i + " i la quantitat d'arxius .m de la carpeta es: "
                        + files_from_directory.size());
                for (x = 0; x < files_from_directory.size(); x++) {
                    System.out.println("El nom de l'arxiu que es mourà es: " + files_from_directory.get(x).getName());
                    files_from_directory.get(x).renameTo(new File(System.getProperty("user.dir")
                            + "/solFile/selectedFile/" + files_from_directory.get(x).getName()));
                }
                //File[] path = getPath(System.getProperty("user.dir") + "/solFile/Path.txt");
                //File generalPath = getOnePath(System.getProperty("user.dir") + "/solFile/Path.txt");
                String command = "/Applications/MATLAB_R2017a.app/bin/matlab -nodesktop -nosplash -r "
                        + "run('" + script + "'); -logfile " + System.getProperty("user.dir")
                        + "/solFile/solutionLogs/logFile" + (i - 1) + ".txt";
                System.out.println(command);
                MatlabControl.executeCommand(command);
                //copyFile(new File(generalPath.getPath()+"/logFile"+(i-1)+".txt"), new File(System.getProperty("user.dir") + "/solFile/solutionlogs/"+(i-1)+".txt"));
            }
            File[] solutionLogs = new File(System.getProperty("user.dir") + "/solFile/solutionLogs").listFiles();
            Validator.compareFilesWithModel(solutionLogs, 1, solu[0]);

            int v = 1;
            while (v < number_of_folders) {
                FileMerge.merge(new File(System.getProperty("user.dir") + "/solFile/wlog" + (v - 1) + ".txt"),
                        new File(System.getProperty("user.dir") + "/solFile/solutionLogs/logFile"
                                + (v - 1) + ".txt"),
                        new File(System.getProperty("user.dir") + "/solFile/finalDocuments/finalDocument"
                                + (v - 1) + ".txt"));
                System.out.println("Merging: wlog" + (v - 1) + ".txt with logFile" + (v - 1) + ".txt into: finalDocument"
                        + (v - 1) + ".txt");
                v++;
            }
            int b = 1;
            while (b < number_of_folders - 1) {
                if (b == 1) {
                    FileMerge.merge(new File(System.getProperty("user.dir") + "/solFile/finalDocuments/finalDocument"
                            + (b - 1) + ".txt"),
                            new File(System.getProperty("user.dir") + "/solFile/finalDocuments/finalDocument"
                                    + (b) + ".txt"),
                            new File(System.getProperty("user.dir") + "/solFile/finalDocuments/fD"
                                    + (b - 1) + ".txt"));
                    System.out.println("Merging: finalDocument" + (b - 1) + ".txt with finalDocument" + (b) + ".txt into: "
                            + "fD" + (b - 1) + ".txt");
                    b++;
                } else {
                    FileMerge.merge(new File(System.getProperty("user.dir") + "/solFile/finalDocuments/fD"
                            + (b - 2) + ".txt"),
                            new File(System.getProperty("user.dir") + "/solFile/finalDocuments/finalDocument"
                                    + (b) + ".txt"),
                            new File(System.getProperty("user.dir") + "/solFile/finalDocuments/fD"
                                    + (b - 1) + ".txt"));
                    System.out.println("Merging: finalDocument" + (b - 2) + ".txt with finalDocument" + (b) + ".txt into: "
                            + "fD" + (b - 1) + ".txt");
                    b++;
                }
            }
            FileMerge.convertTextfileToPDF(new File(System.getProperty("user.dir")
                    + "/solFile/finalDocuments/fD" + (b - 2) + ".txt"));

            response.sendRedirect("LogReader.jsp");
            File dir1 = new File(System.getProperty("user.dir") + "/solFile/solutionLogs");
            File dir2 = new File(System.getProperty("user.dir") + "/solDirectory");
            cleanDirectory(dir1);
            cleanDirectory(dir2);
            return;
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

    public File[] getPath(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        File[] f = new File(br.readLine()).listFiles();
        return f;
    }

    public File getOnePath(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        File f = new File(br.readLine());
        return f;
    }

    public void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public void listf(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            String f = "" + file;
            String substring = f.substring(Math.max(f.length() - 2, 0));
            if (file.isFile() && substring.equals(".m")) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }

    public boolean cleanDirectory(File dir) {
        boolean deleted = false;
        for (File file : dir.listFiles()) {
            if (file.getName().equals("wlog.txt")) {
                //do nothing
            } else {
                //delete file
                file.delete();
                deleted = true;
            }
        }
        return deleted;
    }

}
