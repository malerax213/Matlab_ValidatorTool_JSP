<%-- 
    Document   : LogReader
    Created on : 01-feb-2018, 11:09:03
    Author     : alex
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Text</title>
    </head>
    <body>
        <h1>Results page</h1>
        <table border="1">
            <tr>
                <td align="center"><b>Type of file</b></td>
                <td align="center"><b>See the file</b></td>
                <td align="center"><b>Download file</b></td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <p>Summarized file</p>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="summarizedFile.jsp" method="POST">
                                    <input type="submit" value="See file" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="pdfDownload" method="GET">
                                    <input type="hidden" name="type" value="0" />
                                    <input type="submit" value="Download file" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <p>Full file</p>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="fullFile.jsp" method="POST">
                                    <input type="submit" value="See file" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="pdfDownload" method="GET">
                                    <input type="hidden" name="type" value="1" />
                                    <input type="submit" value="Download file" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <p>CSV file</p>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="CSVFile.jsp" method="POST">
                                    <input type="submit" value="See file" />
                                </form>
                            </td>
                        </tr>
                    </table>

                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="pdfDownload" method="GET">
                                    <input type="hidden" name="type" value="2" />
                                    <input type="submit" value="Download file" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <p></p>
        <table>
            <form name="myForm" action="downloadAll" method="GET">
                <input type="submit" value="Download all files" />
            </form>
        </table>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>