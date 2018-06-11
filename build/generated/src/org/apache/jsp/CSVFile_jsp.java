package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public final class CSVFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Full File</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>CSV File</h1>\n");
      out.write("        <table cellspacing='0' border=\"1\" >\n");
      out.write("            ");

                String fName = System.getProperty("user.dir") + "/solFile/results.csv";
                String thisLine;
                FileInputStream fis = new FileInputStream(fName);
                DataInputStream myInput = new DataInputStream(fis);
                int i = 0;

                while ((thisLine = myInput.readLine()) != null) {
                    String strar[] = thisLine.split(",");
            
      out.write("<tr>");

                for (int j = 0; j < strar.length; j++) {
                    if (i != 0) {
                        out.print("<td> " + strar[j] + "</td> ");
                    } else {
                        out.print(" <td> <b>" + strar[j] + "</b> </td> ");
                    }
                    i++;
                }
                
      out.write("</tr>");

                }
                
      out.write("\n");
      out.write("        </table>\n");
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
