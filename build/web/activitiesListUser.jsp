
<%@page import="java.sql.Blob"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activities</title>
    </head>
    <body>
        <h1>Activities List</h1>
        <p></p>
        <form method="post" action="SelectActivity">

            <table border="1" WIDTH="50%">
                <tr>
                    <td>Activity name</td>
                    <td>Course</td>
                    <td>Single activity test</td>
                </tr>
                <%
                    try {
                        String course = request.getParameter("course");
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/navin";
                        String username = "root";
                        String password = "admin";
                        String query = "select * from activity WHERE course = '"+course+"';";
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {

                %>
                <tr>
                    <td>
                        <table>
                            <tr>
                                <td><%=rs.getString("name")%></td>
                        </table>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td><%=rs.getInt("course")%></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <form action="SelectActivity" method="post">
                                        <input type="hidden" name="saname" value="<%=rs.getString("name")%>" />
                                        <input type="hidden" name="type" value="0" />
                                        <input type="submit" name="button1" value="Test Activity" />
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
            <%
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </form>
        <p></p>
        <p></p>
        <button type="button" name="back" onclick="history.back()">Go back</button>
    </body>
</html>
