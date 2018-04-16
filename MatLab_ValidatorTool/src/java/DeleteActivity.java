/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alexa
 */
@WebServlet(urlPatterns = {"/DeleteActivity"})
public class DeleteActivity extends HttpServlet {

    DeleteActivityDAO dao = new DeleteActivityDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String daname = request.getParameter("daname");
        String course = request.getParameter("course");
        if (dao.sumbit(daname, course)) {
            request.setAttribute("message", "Activity deleted.");
        } else {
            request.setAttribute("message", "It failed!.");
        }
        request.getRequestDispatcher("/resultAdmin.jsp").forward(request, response);
    }

}
