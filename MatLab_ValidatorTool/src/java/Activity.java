/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author alexa
 */
@WebServlet(urlPatterns = {"/Activity"})
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class Activity extends HttpServlet {

    ActivityDAO dao = new ActivityDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String aname = request.getParameter("aname");
        String acourse = request.getParameter("acourse");
        InputStream inputStream1 = null;
        InputStream inputStream2 = null;

        Part file1 = request.getPart("file1");
        Part file2 = request.getPart("file2");
        if (file2 != null && file2 != null) {
            // obtains input stream of the upload file
            inputStream1 = file1.getInputStream();
            inputStream2 = file2.getInputStream();
        }
        if (dao.sumbit(aname, acourse, inputStream1, inputStream2)) {
            request.setAttribute("message", "Activity uploaded.");
        } else {
            request.setAttribute("message", "It failed!.");
        }
        request.getRequestDispatcher("/resultAdmin.jsp").forward(request, response);
    }

}
