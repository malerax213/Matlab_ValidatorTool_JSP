/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author alexa
 */
@WebServlet(urlPatterns = {"/deleteFiles"})
public class DeleteFiles extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File dir = new File(System.getProperty("user.dir") + "/solDirectory/");
        if (deleteDirectory(dir)) {
            request.setAttribute("message", "Files deleted.");
        } else {
            request.setAttribute("message", "Nothing to delete!.");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    boolean deleteDirectory(File directoryToBeDeleted) {
        try {
            FileUtils.deleteDirectory(directoryToBeDeleted);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
