package DBandSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dsp
 */
public class Verifier extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, Exception
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
            String password = null;
            UserTable ut = new UserTable();
            ResultSet rs = ut.select("password", "username='"+request.getParameter("signinFormUsername")+"'");
            
            if(rs.next())
            {
                password = rs.getString("password");
                
                if(password.equals(request.getParameter("signinFormPassword")))
                {
                    ResultSet id = ut.select("id", "username='"+request.getParameter("signinFormUsername")+"'");
                    redirectPath = "dashboard.jsp";
                    
                    if(id.next())
                    {
                        session.setAttribute("userid", id.getInt("id"));
                        session.setAttribute("isLoggedIn", true);
                    }
                    else
                        redirectPath = "index.jsp?error=Unable to verify you signin details.";
                    
                }
                else
                    redirectPath = "index.jsp?error=Password not matched with username.";
            }
            else
                redirectPath = "index.jsp?error=Username does not exists.";
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Verifier.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Verifier.class.getName()).log(Level.SEVERE, null, ex);
        }
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
