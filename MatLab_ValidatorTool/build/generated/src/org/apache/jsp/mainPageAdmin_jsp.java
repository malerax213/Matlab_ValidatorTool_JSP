package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainPageAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MatLab Validator Tool</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            //if (session.getAttribute("username") == null) {
            //response.sendRedirect("login.jsp");
            //}
            //if (!session.getAttribute("username").equals("1")) { // IMPORTANT: CHANGE 1 TO ADMIN
            //response.sendRedirect("mainPage.jsp");
            //}

      out.write("\n");
      out.write("        <h1>Matlab Validator Tool</h1>\n");
      out.write("        <p>Hi, ");
      out.print( session.getAttribute("username"));
      out.write("!</p>\n");
      out.write("        <p>Here you'll be able to select the course you want:</p>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\"><b>1</b></td>\n");
      out.write("                <td align=\"center\"><b>2</b></td>\n");
      out.write("                <td align=\"center\"><b>3</b></td>\n");
      out.write("                <td align=\"center\"><b>4</b></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"activitiesList_1.jsp\" method=\"GET\">\n");
      out.write("                                    <input type=\"submit\" value=\"Select\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"activitiesList_2.jsp\" method=\"GET\">\n");
      out.write("                                    <input type=\"submit\" value=\"Select\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"activitiesList_3.jsp\" method=\"GET\">\n");
      out.write("                                    <input type=\"submit\" value=\"Select\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"activitiesList_4.jsp\" method=\"GET\">\n");
      out.write("                                    <input type=\"submit\" value=\"Select\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <p></p>\n");
      out.write("        <p>Do tests:</p>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\"><b>Activities</b></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\">\n");
      out.write("                    <form name=\"myForm\" action=\"adminTests.jsp\" method=\"GET\">\n");
      out.write("                        <input type=\"submit\" value=\"Go to tests page\" />\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <p></p>\n");
      out.write("        <form method=\"link\" action=\"Logout\">\n");
      out.write("            <input type=\"submit\" value=\"Logout\"/>\n");
      out.write("        </form>\n");
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
