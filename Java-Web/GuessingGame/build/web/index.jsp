<%-- 
    Document   : index
    Created on : Mar 16, 2022, 7:56:54 PM
    Author     : DSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Random"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guessing Game</title>
        <style>
            .container{
                display : flex;
                flex-direction: column;
                width: 20%;
                justify-items: center;
                align-self: center;
            }
            input[type=password], input[type=number], input[type=text]{
                width:10px;
                padding:10px;
                text-align: center;
            }
            input[type=button]{
                margin-bottom: 15px;
                font-size: 11px;
                outline: none;
                border: none;   
                padding: 10px;
                text-align: center;
                cursor: pointer;
                background: background; 
                color: #fff;
                width: 100%;
            }
            h3{
                color: background;
                font-family: cursive;
            }
        </style>
    </head>
    <body onload="initPage()">
        <%
            Random r = new Random();
            int computerNumber[] = new int[8];
            
            for (int i=0; i<8; i++){
                computerNumber[i] = r.nextInt(10);
            }
        %>
    <center>
        <h3>Guessing Game</h3>
        <table cellspacing='15px'>
            <tr>
                <th>Computer Numbers</th>
                <%
                    for(int i=0; i<8; i++)
                        out.print("<td> <input type=password readonly id=comp_number"+ i +" value="+ computerNumber[i] +" /></td>\n");
                %>
            </tr>
            <tr>
                <th>User Number</th>
                <td colspan="7" style="text-align:center"><input style="width: 90%" type="number" min='0' max='9' id='user_num'/></td>
            </tr>
            <tr><td colspan="9"><input type="button" value="Submit" onclick="checkMatch()" /></td></tr>
        </table>
            
            <div id='chance'>You have remain chances : <span id=chance_counter></span></div>
            <div id="result"></div>
    </center>
</body>
<script type='text/javascript'>
    var chanceCounter = 6;
    var comp = [];
    var num1matched=false, num2matched=false, num3matched=false, num4matched=false;
    var num5matched=false, num6matched=false, num7matched=false, num8matched=false;
    function initPage()
    {
        document.getElementById("chance_counter").innerHTML = chanceCounter;
        for(let i = 0; i < 8 ; i++)
        {
            comp[i] = document.getElementById('comp_number'+i).value;
        }
    }
    
    function checkMatch()
    {
        let user = document.getElementById('user_num').value;
        
        let isCorrect = false;
        
        for(let i = 0; i < 8 ; i++)
        {
            if(comp[i] == user)
            {
                switch(i)
                {
                    case 0: document.getElementById("comp_number0").type = "text"; num1matched = true; break;
                    case 1: document.getElementById("comp_number1").type = "text";num2matched = true; break;
                    case 2: document.getElementById("comp_number2").type = "text";num3matched = true; break;
                    case 3: document.getElementById("comp_number3").type = "text";num4matched = true; break;
                    case 4: document.getElementById("comp_number4").type = "text";num5matched = true; break;
                    case 5: document.getElementById("comp_number5").type = "text";num6matched = true; break;
                    case 6: document.getElementById("comp_number6").type = "text";num7matched = true; break;
                    case 7: document.getElementById("comp_number7").type = "text";num8matched = true; break;
                }
                isCorrect = true;
            }
            
            if(num1matched && num2matched && num3matched && num4matched && num5matched && num6matched && num7matched && num8matched)
            {
                document.getElementById("result").innerHTML = "<p style='color:green'>Game Over!!!\nYou are our new Winner.</p>";
                break;
            }
        }
        
        if(!isCorrect)
        {
            chanceCounter--;
            document.getElementById("chance_counter").innerHTML = chanceCounter;
            
            if(chanceCounter == 0)
            {
                document.getElementById("result").innerHTML = "<p style='color:red'>Game Over!!!\nBetter Luck Next Time</p>";
            }
        }
            
    }
</script>
</html>
