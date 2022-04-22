<%-- 
    Document   : index
    Created on : Mar 16, 2022, 2:46:18 PM
    Author     : DSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Random Game</title>
        <style>
            .container{
                display : flex;
                flex-direction: column;
                width: 20%;
                justify-items: center;
                align-self: center;
            }
            input[type=number], input[type=submit]{
                margin-bottom: 15px;
                font-size: 11px;
                outline: none;
                border: solid 1px #ddd;
                padding: 16px;
                text-align: center;
                cursor: pointer;
            }
            input[type=submit]{
                background: background; 
                color: #fff;
            }
            h3{
                color: background;
                font-family: cursive;
            }
        </style>
    </head>
    <body>
        <%
            Random r = new Random();
            String computerNumber = "";
            
            for (int i=0; i<6; i++){
                computerNumber += Integer.toString(r.nextInt(10)) + ",";
            }
        %>
    <center>
        <h3>Random Lottery</h3>
        <form action="ResultPage" class="container" method="post">
            <input type="number" required maxlength="1" min="0" max="9" name="number1" placeholder="Enter Number 1" onkeyup="return checkInput(this)">
            <input type="number" required maxlength="1" min="0" max="9" name="number2" placeholder="Enter Number 2">
            <input type="number" required maxlength="1" min="0" max="9" name="number3" placeholder="Enter Number 3"> 
            <input type="number" required maxlength="1" min="0" max="9" name="number4" placeholder="Enter Number 4">
            <input type="number" required maxlength="1" min="0" max="9" name="number5" placeholder="Enter Number 5">
            <input type="number" required maxlength="1" min="0" max="9" name="number6" placeholder="Enter Number 6">
            <input type="submit" value="Submit">
            <% out.println("<input type='hidden' name='computerNumber' value='"+ computerNumber +"' />"); %>
        </form>
        </center>
        
        
    </body>
</html>
