
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tests page</title>
    </head>
    <body>
        <%
            // IMPORTANT: Add admin conditions
%>
        <h1>Tests page</h1>
        <p>How to do tests:</p>
        <p>Step 1: Enter the name of the activity</p>
        <table>
            <tr>
                <td>
                    <form action="SelectActivity" method="post">
                        Re-enter the name: <input type ="text" name="saname"><br>
                        <input type="submit" name="button1" value="Select Activity" />
                    </form>
                </td>
            </tr>
        </table>
        <p>Step 2: Sumbit the solution you want to test</p>
        <table border="1">
            <tr>
                <td align="center"><b>Code</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form name="myForm" action="uploadPage1.jsp" method="POST">
                        <input type="submit" value="Upload code" />
                    </form>
                </td>
            </tr>
        </table>
        <p>Step 3: Press Validate</p>
        <table border="1">
            <tr>
                <td align="center"><b>Tool</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form action="${pageContext.request.contextPath}/myServlet" method="post">
                        <input type="submit" name="button1" value="Validate" />
                    </form>  
                </td>
            </tr>
        </table>
        <p>Extra 1: Delete all the test files</p>
        <table border="1">
            <tr>
                <td align="center"><b>Delete</b></td>
            </tr>
            <tr>
                <td align="center">
                    <form action="deleteFiles" method="post">
                        <input type="submit" name="button1" value="Delete test files" />
                    </form>
                </td>
            </tr>
        </table>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
