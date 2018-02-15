package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.File;

public final class mainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>MatLab Validator Tool</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Matlab Validator Tool</h1>\n");
      out.write("        <p>How to use this validator: </p>\n");
      out.write("        <p>Step 1: Upload the code pressing the \"Upload code\" button from the \"Code\" table </p>\n");
      out.write("        <p>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\"><b>Code</b></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\">\n");
      out.write("                    <form name=\"myForm\" action=\"uploadPage1.jsp\" method=\"POST\">\n");
      out.write("                        <input type=\"submit\" value=\"Upload code\" />\n");
      out.write("                    </form>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </p>\n");
      out.write("    \n");
      out.write("    <p>Step 2: Upload the solution file pressing the \"Upload solution\" button from the \"Solution\" table </p>\n");
      out.write("    <p>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"center\"><b>Solution</b></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td align=\"center\">\n");
      out.write("                <form name=\"myForm\" action=\"uploadPage2.jsp\" method=\"POST\">\n");
      out.write("                    <input type=\"submit\" value=\"Upload solution\" />\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("<p>Step 3: Press the \"Validate\" button from the \"Tool\" table in order to check if the code passes the tests</p>\n");
      out.write("<p>\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <td align=\"center\"><b>Tool</b></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("        <td align=\"center\">\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/myServlet\" method=\"post\">\n");
      out.write("                <input type=\"submit\" name=\"button1\" value=\"Validate\" />\n");
      out.write("            </form>  \n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("</table>\n");
      out.write("</p>\n");
      out.write("\n");
      out.write("</body>\n");
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
