<%-- 
    Document   : Test
    Created on : 14-Apr-2022, 6:46:12 pm
    Author     : dsp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.ResultSet,DBandSession.UserTable, DBandSession.User"%>
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
            User u = new User("Santosh Patel", "Male", "+916351909611", "Mirzapar", "Painting, Singing", "sdpael", "sdp@737");
            if(ut.insert(u))
                out.print("Lala...la");
            else
                out.print("Naa");
        %>
    </body>
</html>
