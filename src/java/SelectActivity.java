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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
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
@WebServlet(urlPatterns = {"/SelectActivity"})
public class SelectActivity extends HttpServlet {

    SelectActivityDAO dao = new SelectActivityDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String saname = request.getParameter("saname");
        ServletContext context = getServletContext();
        try {
            if (dao.sumbit(saname, request, response, context)) {
                request.setAttribute("message", "Activity selected.");
            } else {
                request.setAttribute("message", "It failed!.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectActivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/resultAdmin.jsp").forward(request, response);
    }

}
