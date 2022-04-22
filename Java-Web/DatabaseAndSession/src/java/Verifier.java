/**
 *
 * @author DSP
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class Verifier extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String redirectPath = "";
        String action = request.getParameter("action");
        
        if(action != null && action.equals("Signup"))
        {
            HttpSession session = request.getSession();
            
            session.setAttribute("fullname", request.getParameter("signupFormFullName"));
            session.setAttribute("username", request.getParameter("signupFormUsername"));
            session.setAttribute("password", request.getParameter("signupFormPassword"));
            session.setAttribute("isLoggedIn", true);
            
            redirectPath = "dashboard.jsp";
            
            session.setMaxInactiveInterval(1500);
        }
        else if(action != null && action.equals("Signin"))
        {
            HttpSession session = request.getSession();
            
            Object username = session.getAttribute("username");
            Object password = session.getAttribute("password");
            
            if(username != null && password != null)
            {
                if(username.toString().equals(request.getParameter("signinFormUsername")))
                {
                    if(password.toString().equals(request.getParameter("signinFormPassword")))
                    {
                        redirectPath = "dashboard.jsp";
                        session.setAttribute("isLoggedIn", true);
                    }
                    
                    else
                        redirectPath = "index.jsp?error=Password not matched with username.";
                }
                else
                    redirectPath = "index.jsp?error=Username not matched with our records.";
            }
            else
                redirectPath = "signup.jsp?error=User not found. Please signup first.";
        }
        
        response.sendRedirect(redirectPath);
       
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
