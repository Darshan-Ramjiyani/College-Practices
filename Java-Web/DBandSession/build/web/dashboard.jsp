<%-- 
    Document   : dashboard
    Created on : Apr 3, 2022, 7:46:57 PM
    Author     : DSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="DBandSession.*, java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>

        <title>Dashboard | Dwiadh</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Styles/styles.css">

    </head>
    <body class="d-flex flex-row">
        <div class="container my-auto">
            <div class="row">
                <div class="col-12">
                    <p class="h1 text-center text-danger">Welcome 
                        <% 
                            UserTable ut = new UserTable();
                            ResultSet rs = ut.select("full_name", "uid="+session.getAttribute("userid")+"");
                            out.println(rs.next() ? rs.getString(1) : "N/A");
                        %>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>
