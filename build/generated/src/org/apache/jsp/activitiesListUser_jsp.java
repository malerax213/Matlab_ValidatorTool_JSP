package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class activitiesListUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Activities</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Activities List</h1>\n");
      out.write("        <form method=\"post\">\n");
      out.write("\n");
      out.write("            <table border=\"1\" WIDTH=\"50%\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Activity name</td>\n");
      out.write("                    <td>Course</td>\n");
      out.write("                    <td>Solution uploaded</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/navin";
                        String username = "root";
                        String password = "admin";
                        String query = "select * from activity";
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {

                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(rs.getString("name"));
      out.write("</td>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(rs.getInt("course"));
      out.write("</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                    ");

                        Blob b = rs.getBlob("solution");
                        if (!rs.wasNull()) {
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Si</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>No</td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </td>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");

                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <p></p>\n");
      out.write("        <p></p>\n");
      out.write("        <button type=\"button\" name=\"back\" onclick=\"history.back()\">Go back</button>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
