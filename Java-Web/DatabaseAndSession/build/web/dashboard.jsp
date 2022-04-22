<%-- 
    Document   : dashboard
    Created on : Apr 3, 2022, 7:46:57 PM
    Author     : DSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Dashboard | Session- DSP</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Styles/styles.css">
        
    </head>
    <body>
        <main>
            <section class="container h-100">
                <div class="row d-flex d-flex-column justify-content-center">
                    <span class="text-center text-danger h2 p-6"><%= session.getAttribute("fullname") %></span>
                </div>
            </section>
        </main>
    </body>
</html>
