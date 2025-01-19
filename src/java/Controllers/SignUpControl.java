package Controllers;

import DAL.DAO;
import Models.Accounts;
import Utils.MaHoa;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String repass = request.getParameter("repassword");
        if (user == null || pass == null || email == null) {
            user = "abc1";
            pass = "123";
        }

        DAO d = new DAO();
        Accounts a = d.checkUsername(user);
        Accounts a1 = d.checkEmail(email);

        if (a != null) { 
            request.setAttribute("msg", "Username already exists.");
            request.getRequestDispatcher("Views/SignUp.jsp").forward(request, response);
        } else if (a1 != null) { 
            request.setAttribute("msg", "Email already exists.");
            request.getRequestDispatcher("Views/SignUp.jsp").forward(request, response);
        } else if (!pass.equals(repass)) {
            request.setAttribute("msg", "Password does not match.");
            request.getRequestDispatcher("Views/SignUp.jsp").forward(request, response);
        } else {
            String hashedPassword = MaHoa.hashPassword(pass);
            d.checkSignUp(user, hashedPassword, email);
            request.getRequestDispatcher("CreateProfile").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignUpControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignUpControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
