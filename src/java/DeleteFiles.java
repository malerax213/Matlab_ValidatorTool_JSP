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
        if (cleanDirectory(dir)) {
            request.setAttribute("message", "Files deleted.");
        } else {
            request.setAttribute("message", "Nothing to delete!.");
        }
        request.getRequestDispatcher("/resultAdmin.jsp").forward(request, response);
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
