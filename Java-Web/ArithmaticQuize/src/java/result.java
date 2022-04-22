/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSP
 */
public class result extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet result</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<table border='1' cellpadding='5'>");
            
            float useradd = Float.parseFloat(request.getParameter("add"));
            float usersub = Float.parseFloat(request.getParameter("sub"));
            float usermul = Float.parseFloat(request.getParameter("mul"));
            float userdiv = Float.parseFloat(request.getParameter("div"));
            
            float comadd = Float.parseFloat(request.getParameter("addans"));
            float comsub = Float.parseFloat(request.getParameter("subans"));
            float commul = Float.parseFloat(request.getParameter("mulans"));
            float comdiv = Float.parseFloat(request.getParameter("divans"));
            
            boolean add, sub, mul, div;
            
            add = true ? (useradd == comadd) : false;
            sub = true ? (usersub == comsub) : false;
            mul = true ? (usermul == commul) : false;
            div = true ? (userdiv == comdiv) : false;
            
            int r1,r2,r3,r4,r5,r6,r7,r8;
            int totalCorrect = 0;
           
            r1 = Integer.parseInt(request.getParameter("rn1"));
            r2 = Integer.parseInt(request.getParameter("rn2"));
            r3 = Integer.parseInt(request.getParameter("rn3"));
            r4 = Integer.parseInt(request.getParameter("rn4"));
            r5 = Integer.parseInt(request.getParameter("rn5"));
            r6 = Integer.parseInt(request.getParameter("rn6"));
            r7 = Integer.parseInt(request.getParameter("rn7"));
            r8 = Integer.parseInt(request.getParameter("rn8"));
            
            out.println("<tr>");
            out.println("<th>Question</th>");
            out.println("<th>User Answer</th>");
            out.println("<th>Computer Answer</th>");
            out.println("<th>Check</th>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+r1+" + "+r2+" = </td>");
            out.println("<td>"+useradd+"</td>");
            out.println("<td>"+comadd+"</td>");
            if(add){
                out.println("<td style='color:GREEN'>CORRECT</td>");
                totalCorrect += 1;
            }else{
                out.println("<td style='color:RED'>WRONG</td>");
            }
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+r3+" - "+r4+" = </td>");
            out.println("<td>"+usersub+"</td>");
            out.println("<td>"+comsub+"</td>");
            if(sub){
                out.println("<td style='color:GREEN'>CORRECT</td>");
                totalCorrect += 1;
            }else{
                out.println("<td style='color:RED'>WRONG</td>");
            }
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+r5+" * "+r6+" = </td>");
            out.println("<td>"+usermul+"</td>");
            out.println("<td>"+commul+"</td>");
            if(mul){
                out.println("<td style='color:GREEN'>CORRECT</td>");
                totalCorrect += 1;
            }else{
                out.println("<td style='color:RED'>WRONG</td>");
            }
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+r7+" / "+r8+" = </td>");
            out.println("<td>"+userdiv+"</td>");
            out.println("<td>"+comdiv+"</td>");
            if(div){
                out.println("<td style='color:GREEN'>CORRECT</td>");
                totalCorrect += 1;
            }else{
                out.println("<td style='color:RED'>WRONG</td>");
            }
            out.println("</tr>");

            out.println("</table>");
            
            switch(totalCorrect){
                case 0:
                    out.println("<h1 style='color:RED'>ALL OF YOUR ANSWERS ARE WRONG.</h1>");
                    break;
                case 1:
                    out.println("<h1 style='color:GREEN'>25% OF YOUR ANSWERS ARE CORRECT.</h1>");
                    out.println("<h1 style='color:RED'>75% OF YOUR ANSWERS ARE WRONG.</h1>");
                    break;
                case 2:
                    out.println("<h1 style='color:GREEN'>50% OF YOUR ANSWERS ARE CORRECT.</h1>");
                    out.println("<h1 style='color:RED'>50% OF YOUR ANSWERS ARE WRONG.</h1>");
                    break;
                case 3:
                    out.println("<h1 style='color:GREEN'>75% OF YOUR ANSWERS ARE CORRECT.</h1>");
                    out.println("<h1 style='color:RED'>25% OF YOUR ANSWERS ARE WRONG.</h1>");
                    break;
                case 4:
                    out.println("<h1 style='color:GREEN'>100% OF YOUR ANSWERS ARE CORRECT. CONGRATULATATIONS.</h1>");
                    break;
            }
            
            out.println("</center></body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
