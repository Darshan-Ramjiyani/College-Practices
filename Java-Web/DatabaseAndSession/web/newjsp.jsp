<%-- 
    Document   : Test
    Created on : 14-Apr-2022, 6:46:12 pm
    Author     : dsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.ResultSet, "%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            UserTable ut = new UserTable();
            ResultSet rs = ut.select("username", "");

            if(rs.first())
            {
                out.println(rs.getString("username"));
            }
            else
            {
                out.println("No records found!");
            }
        %>
    </body>
</html>
