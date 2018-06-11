
import Validator.MatlabControl;
import Validator.Validator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
            File tempStore = new File(System.getProperty("user.dir") + "/solFile/selectedFile/.DS_STORE");
            tempStore.delete();
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
            StringTokenizer st = null;
            String[] names = new String[number_of_folders];
            String[] sum = new String[number_of_folders];
            for (int i = 1; i < number_of_folders; i++) {
                String script = "" + uploaded[0];
                script = script.substring(0, script.length() - 2);
                ArrayList<File> files_from_directory = new ArrayList();
                System.out.println("Path: " + files[i].getPath() + " Number of folders: " + number_of_folders
                        + " i: " + i);
                listf(files[i].getPath(), files_from_directory);

                st = new StringTokenizer(files[i].getName(), ", ()");
                int n = 0;
                StringBuilder sb = new StringBuilder();
                while (n < 3) {
                    sb.append(st.nextToken());
                    sb.append(" ");
                    n++;
                }
                String temp = files[i].getName().substring(files[i].getName().length() - 5);
                String temp2 = temp.substring(0, temp.lastIndexOf(")"));
                names[i - 1] = sb.toString();
                sum[i - 1] = temp2;
                System.out.println("El nom es: " + names[i - 1] + ", la i es: " + i + " i la quantitat d'arxius .m de la carpeta "
                        + "es: " + files_from_directory.size());
                for (x = 0; x < files_from_directory.size(); x++) {
                    System.out.println("El nom de l'arxiu que es mourà es: " + files_from_directory.get(x).getName());
                    files_from_directory.get(x).renameTo(new File(System.getProperty("user.dir")
                            + "/solFile/selectedFile/" + files_from_directory.get(x).getName()));
                }
                String command = "/Applications/MATLAB_R2017a.app/bin/matlab -nodesktop -nosplash -r "
                        + "run('" + script + "'); -logfile " + System.getProperty("user.dir")
                        + "/solFile/solutionLogs/logFile" + (i - 1) + ".txt";
                System.out.println(command);
                MatlabControl.executeCommand(command);
            }
            File[] solutionLogs = new File(System.getProperty("user.dir") + "/solFile/solutionLogs").listFiles();
            Validator.compareFilesWithModelWithNames(solutionLogs, 1, solu[0], names, sum);

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
            generateFinalLog();
            File finalDoc = new File(System.getProperty("user.dir") + "/solFile/finalDocuments/fD" + (b - 2) + ".txt");
            File newFile = new File(finalDoc.getParent(), "finalDocument.txt");
            Files.move(finalDoc.toPath(), newFile.toPath());
            FileMerge.convertTextfileToPDF(new File(System.getProperty("user.dir")
                    + "/solFile/finalDocuments/finalDocument.txt"));
            FileMerge.convertTextfileToPDF(new File(System.getProperty("user.dir")
                    + "/solFile/finalLog.txt"));

            response.sendRedirect("LogReader.jsp");
            File dir1 = new File(System.getProperty("user.dir") + "/solFile/solutionLogs");
            cleanDirectory(dir1);
            File dir2 = new File(System.getProperty("user.dir") + "/solDirectory");
            deleteDirectory(dir2);
            return;
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

    public void generateFinalLog() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File dir = new File(System.getProperty("user.dir") + "/solFile");
        File[] found = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("wlog");
            }
        });
        PrintWriter log = new PrintWriter(System.getProperty("user.dir")
                + "/solFile/finalLog.txt", "UTF-8");
        for (int i = 0; i < found.length; i++) {
            File txtFilePath = new File(System.getProperty("user.dir") + "/solFile/wlog" + i + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                log.println(line);
            }
            log.println("\n");
        }
        log.close();
    }

    boolean deleteDirectory(File directoryToBeDeleted) {
        try {
            FileUtils.deleteDirectory(directoryToBeDeleted);
            return true;
        } catch (Exception e) {
            return false;
        }
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
