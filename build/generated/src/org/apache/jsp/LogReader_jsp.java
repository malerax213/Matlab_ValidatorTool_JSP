package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.FilenameFilter;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileReader;
import java.io.BufferedReader;

public final class LogReader_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Read Text</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Results page</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\"><b>Type of file</b></td>\n");
      out.write("                <td align=\"center\"><b>See the file</b></td>\n");
      out.write("                <td align=\"center\"><b>Download file</b></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <p>Summarized file</p>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"summarizedFile.jsp\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" value=\"See file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"pdfDownload\" method=\"GET\">\n");
      out.write("                                    <input type=\"hidden\" name=\"type\" value=\"0\" />\n");
      out.write("                                    <input type=\"submit\" value=\"Download file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <p>Full file</p>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"fullFile.jsp\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" value=\"See file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"pdfDownload\" method=\"GET\">\n");
      out.write("                                    <input type=\"hidden\" name=\"type\" value=\"1\" />\n");
      out.write("                                    <input type=\"submit\" value=\"Download file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <p>CSV file</p>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"CSVFile.jsp\" method=\"POST\">\n");
      out.write("                                    <input type=\"submit\" value=\"See file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td align=\"center\">\n");
      out.write("                                <form name=\"myForm\" action=\"pdfDownload\" method=\"GET\">\n");
      out.write("                                    <input type=\"hidden\" name=\"type\" value=\"2\" />\n");
      out.write("                                    <input type=\"submit\" value=\"Download file\" />\n");
      out.write("                                </form>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <p></p>\n");
      out.write("        Note: The CSV file is only generated for the multiple tests\n");
      out.write("        <p></p>\n");
      out.write("        <table>\n");
      out.write("            <form name=\"myForm\" action=\"downloadAll\" method=\"GET\">\n");
      out.write("                <input type=\"submit\" value=\"Download all files\" />\n");
      out.write("            </form>\n");
      out.write("        </table>\n");
      out.write("        <p></p>\n");
      out.write("        <button type=\"button\" name=\"back\" onclick=\"history.back()\">Go back</button>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
