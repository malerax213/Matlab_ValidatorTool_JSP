

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/SelectActivity"})
public class SelectActivity extends HttpServlet {

    SelectActivityDAO dao = new SelectActivityDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String saname = request.getParameter("saname");
        String type = request.getParameter("type");
        ServletContext context = getServletContext();
        try {
            if (type.equals("0")) {
                if (dao.sumbit(saname, request, response, context)) {
                    response.sendRedirect("adminTests.jsp");
                }
            } else {
                if (dao.sumbit(saname, request, response, context)) {
                    response.sendRedirect("adminMultipleTests.jsp");
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectActivity.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
