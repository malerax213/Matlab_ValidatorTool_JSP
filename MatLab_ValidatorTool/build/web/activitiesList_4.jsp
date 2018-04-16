<%-- 
    Document   : activitiesList
    Created on : 09-mar-2018, 11:39:58
    Author     : alexa
--%>
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
        <p>Create an activity:</p>
        <form name="myForm" action="createActivity.jsp" method="GET">
            <input type="submit" value="Create" />
        </form>
        <p></p>
        <form method="post" action="DeleteActivity">

            <table border="1" WIDTH="50%">
                <tr>
                    <td>Activity name</td>
                    <td>Course</td>
                    <td>Delete Activity</td>
                    <td>Test Activity</td>
                </tr>
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/navin";
                        String username = "root";
                        String password = "admin";
                        String query = "select * from activity WHERE course = 4";
                        Connection conn = DriverManager.getConnection(url, username, password);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        int i = 0;
                        while (rs.next()) {
                            i++;
                %>
                <tr>
                    <td>
                        <table>
                            <tr>
                                <td><%=rs.getString("name")%></td>
                            </tr>
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
                                    <form action="DeleteActivity" method="post">
                                        <input type="hidden" name="daname" value="<%=rs.getString("name")%>" />
                                        <input type="hidden" name="course" value="4" />
                                        <input type="submit" name="button4" value="Delete Activity" />
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    <form action="SelectActivity" method="post">
                                        <input type="hidden" name="saname" value="<%=rs.getString("name")%>" />
                                        <input type="submit" name="button5" value="Test Activity" />
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
