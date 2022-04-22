<%-- 
    Document   : index
    Created on : Mar 16, 2022, 9:35:48 PM
    Author     : DSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <h1>Login</h1>
        <%
            Cookie[] cookies = request.getCookies();
            
            if(cookies != null)
            {
                for( Cookie cookie: cookies )
                {
                    if(cookie.getName().equals("loginCredential") && !cookie.getValue().equals(""))
                        response.sendRedirect("Dashboard");
                }
            }
        %>
        
        <form method="post" action="Dashboard" >
            <table cellspacing="10px" cellpadding="5px">
                <tr>
                    <th>Username</th>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input style="width : 100%" type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
        
        <div style="padding: 16px;">
            <%
                if(request.getParameter("status") != null)
                    out.println(request.getParameter("status"));
            %>
        </div>
        
    </center>
    </body>
</html>
