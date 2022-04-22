
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Matching the user input with the computer guessed number.
 *
 * @author DSP
 */
public class ResultPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String[] compNum = request.getParameter("computerNumber").split(",");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultPage</title>");
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h3>Lottery Draw</h3>");
            out.println("<table cellpadding=\"5px\" cellspacing=\"10px\">\n"
                    + "            <tr>\n"
                    + "                <th>\n"
                    + "                    Computer Lottery Number \n"
                    + "                </th>\n"
                    + "                <td>\n"
                    + "                    " + compNum[0]
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + compNum[1]
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + compNum[2]
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + compNum[3]
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + compNum[4]
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + compNum[5]
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <th>\n"
                    + "                    User Lottery Number \n"
                    + "                </th>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number1")
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number2")
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number3")
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number4")
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number5")
                    + "                </td>\n"
                    + "                <td>\n"
                    + "                    " + request.getParameter("number6")
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td colspan=\"7\"><hr /></td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <th>\n"
                    + "                    Matches\n"
                    + "                </th>\n");
            if(request.getParameter("number1").equals(compNum[0])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            if(request.getParameter("number2").equals(compNum[1])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            if(request.getParameter("number3").equals(compNum[2])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            if(request.getParameter("number4").equals(compNum[3])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            if(request.getParameter("number5").equals(compNum[4])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            if(request.getParameter("number6").equals(compNum[5])) out.println("<td style='color:green'>M</td>"); else out.println("<td style='color:red'>X</td>");
            
            out.println("</tr></table>");
            
            if(request.getParameter("number6").equals(compNum[5]) && request.getParameter("number5").equals(compNum[4]) && request.getParameter("number4").equals(compNum[3]) && request.getParameter("number3").equals(compNum[2]) && request.getParameter("number2").equals(compNum[1]) && request.getParameter("number1").equals(compNum[0])) out.println("<div style='color:green'>Hooray! You win lottery! Now, get lost.😒</div>"); else out.println("<div style='color:red'>Oops! You lost. Come Again 😊</div>");
            
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
