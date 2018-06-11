
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Single activity test page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Single activity test page</h1>
        <p></p>
        <table border="1">
            <tr>
                <td align="center"><b>Instruction</b></td>
                <td align="center"><b>Button</b></td>
            </tr>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <p>Step 1: Sumbit the solution you want to test</p>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form name="myForm" action="uploadPage1.jsp" method="POST">
                                    <input type="submit" value="Upload code" />
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
                                <p>Step 2: Press Validate</p>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <table>
                        <tr>
                            <td align="center">
                                <form action="${pageContext.request.contextPath}/myServlet" method="post">
                                    <input type="submit" name="button1" value="Validate" />
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <p></p>
        <p>Note: All the uploaded files will be deleted after pressing the "Validate" button.</p>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
