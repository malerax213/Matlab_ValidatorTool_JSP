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
        InputStream inputStream = null;

        Part file = request.getPart("file");
        if (file != null) {
            // prints out some information for debugging
            System.out.println(file.getName());
            System.out.println(file.getSize());
            System.out.println(file.getContentType());

            // obtains input stream of the upload file
            inputStream = file.getInputStream();
        }
        if (dao.sumbit(aname, acourse, inputStream)) {
            request.setAttribute("message", "Activity uploaded.");
        } else {
            request.setAttribute("message", "It failed!.");
        }
        request.getRequestDispatcher("/resultAdmin.jsp").forward(request, response);
    }

}
