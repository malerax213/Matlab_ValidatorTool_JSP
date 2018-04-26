
import Validator.MatlabControl;
import Validator.Validator;
import static Validator.Validator.compareFilesWithModel;
import java.io.File;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // How to improve. If a there are a lot of files uploaded, do a for and execute the command for each file and generate 1 log for each execution
        // Then compare each log file with the solution of the activity selected
        if (request.getParameter("button1") != null) {
            MatlabControl mc = new MatlabControl();
            File[] files = new File(System.getProperty("user.dir") + "/solDirectory").listFiles();
            new File(System.getProperty("user.dir") + "/solFile/selectedFile/").mkdirs();
            File[] uploaded = new File(System.getProperty("user.dir") + "/solFile/selectedFile/").listFiles();
            new File(System.getProperty("user.dir") + "/solFile/solutionLogs/").mkdirs();
            File[] solu = new File(System.getProperty("user.dir") + "/solFile/sol/").listFiles();
            File sL = new File(System.getProperty("user.dir") + "/solFile/solutionLogs");
            cleanDirectory(sL);
            String command;

            if (uploaded.length > 1) { //If there's a script to execute
                String script = "" + uploaded[0];
                script = script.substring(0, script.length() - 2);
                for (int x = 0; x < files.length; x++) {
                    files[x].renameTo(new File(System.getProperty("user.dir") + "/solFile/selectedFile/" + files[x].getName()));
                }
                command = "matlab -nodesktop -nosplash -minimize -r \"run('" + script + "');\" -logfile " + System.getProperty("user.dir") + "/solFile/solutionLogs/wmlog.txt";
            } else {
                String sol = "" + files[0];
                sol = sol.substring(0, sol.length() - 2);
                command = "matlab -nodesktop -nosplash -minimize -r \"run('" + sol + "');\" -logfile " + System.getProperty("user.dir") + "/solFile/solutionLogs/wmlog.txt";
            }
            mc.executeCommand(command);
            try {
                Thread.sleep(7500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            File[] solutionLogs = new File(System.getProperty("user.dir") + "/solFile/solutionLogs").listFiles();
            Validator.compareFilesWithModel(solutionLogs, 1, solu[0]);
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
