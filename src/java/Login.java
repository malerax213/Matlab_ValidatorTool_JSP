
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    LoginDAO dao = new LoginDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (dao.check(uname, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            response.sendRedirect("mainPageAdmin.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

}
