import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DSP
 */
public class questions extends HttpServlet {

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
            out.println("<title>Servlet quizquestions</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<form action='result' method='GET'>");
            
            Random r1  = new Random();
            int rn1 = r1.nextInt(10);
            int rn2 = r1.nextInt(10);
            int rn3 = r1.nextInt(10);
            int rn4 = r1.nextInt(10);
            int rn5 = r1.nextInt(10);
            int rn6 = r1.nextInt(10);
            int rn7 = r1.nextInt(10);
            int rn8 = r1.nextInt(10);
           
            
            
            out.println(rn1 + " + " + rn2 + " = <input type='number' name='add' required ><br><br>");
            out.println(rn3 + " - " + rn4 + " = <input type='number' name='sub' required ><br><br>");
            out.println(rn5 + " * " + rn6 + " = <input type='number' name='mul' required ><br><br>");
            out.println(rn7 + " / " + rn8 + " = <input type='number' name='div' required ><br><br>");
            
            out.println("<input type='hidden' value='"+(rn1+rn2)+"' name='addans'>");
            out.println("<input type='hidden' value='"+(rn3-rn4)+"' name='subans'>");
            out.println("<input type='hidden' value='"+(rn5*rn6)+"' name='mulans'>");
            out.println("<input type='hidden' value='"+(rn7/rn8)+"' name='divans'>");
            
            out.println("<input type='hidden' value='"+(rn1)+"' name='rn1'>");
            out.println("<input type='hidden' value='"+(rn2)+"' name='rn2'>");
            out.println("<input type='hidden' value='"+(rn3)+"' name='rn3'>");
            out.println("<input type='hidden' value='"+(rn4)+"' name='rn4'>");
            out.println("<input type='hidden' value='"+(rn5)+"' name='rn5'>");
            out.println("<input type='hidden' value='"+(rn6)+"' name='rn6'>");
            out.println("<input type='hidden' value='"+(rn7)+"' name='rn7'>");
            out.println("<input type='hidden' value='"+(rn8)+"' name='rn8'>");
            
            
            out.println("<input type='submit' value='OK'>");
            
            out.println("</form>");
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
