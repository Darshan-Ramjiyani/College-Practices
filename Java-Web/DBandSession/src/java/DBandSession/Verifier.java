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
import java.io.PrintWriter;

/**
 *
 * @author dsp
 */
public class Verifier extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, Exception
    {
        PrintWriter out = response.getWriter();
        out.print("Verifying details...");
        String redirectPath = "";
        String action = request.getParameter("action");
        
        UserTable userTable = new UserTable();
            
        if(action != null && action.equals("Signup"))
        {
            User user = new User(
                request.getParameter("signupFormFullname"),
                request.getParameter("signupFormGender"),
                request.getParameter("signupFormEmail"),
                request.getParameter("signupFormPassword"),
                request.getParameter("signupFormDOB")
            );
            System.err.println("DOB : " + 
                request.getParameter("signupFormDOB"));
            redirectPath = userTable.insert(user) > 0 ? "dashboard.jsp" : "signup?error=Unable register you at this moment.";
            ResultSet id = userTable.select("uid", "email='"+request.getParameter("signupFormEmail")+"'");
            if(id.next())
            {
                HttpSession session = request.getSession();
                session.setAttribute("userid", id.getInt("uid"));
                session.setAttribute("isLoggedIn", true);
            }
            else
                redirectPath = "index.jsp?error=Unable to verify your signup details.";
            
        }
        else if(action != null && action.equals("Signin"))
        {
            String password = null;
            ResultSet rs = userTable.select("password", "email='"+request.getParameter("signinFormUsername")+"'");
            
            if(rs.next())
            {
                password = rs.getString("password");
                
                if(password.equals(request.getParameter("signinFormPassword")))
                {
                    ResultSet id = userTable.select("uid", "email='"+request.getParameter("signinFormUsername")+"'");
                    redirectPath = "dashboard.jsp";
                    
                    if(id.next())
                    {
                        HttpSession session = request.getSession();
                        session.setAttribute("userid", id.getInt("uid"));
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
