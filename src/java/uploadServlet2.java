/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alexa
 */

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet2")
public class uploadServlet2 extends HttpServlet {

    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/solFile";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        File dir = new File(System.getProperty("user.dir") + "/solFile/selectedFile");
                        dir.mkdir();
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                request.setAttribute("message", "File uploaded successfully at: " + System.getProperty("user.dir") + "/solFile");
            } catch (Exception ex) {
                request.setAttribute("message", "File upload failed due to : " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry this servlet only handles file upload request.");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

}
