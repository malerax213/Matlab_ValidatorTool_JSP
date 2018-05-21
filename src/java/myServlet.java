
import Validator.MatlabControl;
import Validator.Validator;
import static Validator.Validator.compareFilesWithModel;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
            IOException {
        // How to improve. If a there are a lot of files uploaded, do a for and execute the command for each file and generate 1 log for each execution
        // Then compare each log file with the solution of the activity selected
        if (request.getParameter("button1") != null) {
            MatlabControl mc = new MatlabControl();
            File[] files = new File(System.getProperty("user.dir") + "/solDirectory").listFiles();
            new File(System.getProperty("user.dir") + "/solFile/selectedFile/").mkdirs();
            File[] uploaded = new File(System.getProperty("user.dir") + "/solFile/selectedFile/").listFiles();
            File sL = new File(System.getProperty("user.dir") + "/solFile/solutionLogs");
            sL.mkdirs();
            File[] solu = new File(System.getProperty("user.dir") + "/solFile/sol/").listFiles();
            File dir1 = new File(System.getProperty("user.dir") + "/solFile/finalDocuments");
            dir1.mkdir();
            cleanDirectory(dir1);
            cleanDirectory(sL);
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
            String command;

            if (uploaded.length > 1) { //If there's a script to execute
                String script = "" + uploaded[0];
                script = script.substring(0, script.length() - 2);
                for (int x = 0; x < files.length; x++) {
                    files[x].renameTo(new File(System.getProperty("user.dir") + "/solFile/selectedFile/" + 
                            files[x].getName()));
                }
                command = "/Applications/MATLAB_R2017a.app/bin/matlab -nodesktop -nosplash -r run('" + script + "'); "
                        + "-logfile " + System.getProperty("user.dir") + "/solFile/solutionLogs/wmlog.txt";
                MatlabControl.executeCommand(command);
            }
            File finalDocument = new File(System.getProperty("user.dir")+"/solFile/finalDocuments/finalDocument.txt");
            File[] solutionLogs = new File(System.getProperty("user.dir") + "/solFile/solutionLogs").listFiles();
            Validator.compareFilesWithModel(solutionLogs, 1, solu[0]);
            FileMerge.merge(new File(System.getProperty("user.dir") + "/solFile/wlog0.txt"), 
                    new File(System.getProperty("user.dir")+"/solFile/solutionLogs/wmlog.txt"), 
                    finalDocument);
            FileMerge.convertTextfileToPDF(new File(System.getProperty("user.dir")+"/solFile/finalDocuments/"
                    + "finalDocument.txt"));
            finalDocument.delete();
            File dir2 = new File(System.getProperty("user.dir") + "/solDirectory");
            cleanDirectory(dir2);
            response.sendRedirect("LogReader.jsp");
            return;
        } else {
            // ???
        }

        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
