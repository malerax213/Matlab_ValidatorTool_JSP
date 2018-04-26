
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

@WebServlet("/FolderServlet")
public class FolderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String folder_path = request.getParameter("f_path");
        PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "/solFile/path.txt", "UTF-8");
        writer.println(folder_path);
        writer.close();
        String source = folder_path;
        File srcDir = new File(source);

        File dir = new File(System.getProperty("user.dir") + "/solDirectory");
        dir.mkdir();

        String destination = System.getProperty("user.dir") + "/solDirectory/";
        File destDir = new File(destination);

        FileUtils.copyDirectory(srcDir, destDir);

        request.setAttribute("message", "Folder uploaded successfully at: " + System.getProperty("user.dir") + "/solDirectory");

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

}
