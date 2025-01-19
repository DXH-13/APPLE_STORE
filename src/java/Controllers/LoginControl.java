package Controllers;

import DAL.DAO;
import Models.Accounts;
import Utils.MaHoa;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            HttpSession ses = request.getSession();
            DAO d = new DAO();
            d.loadDB();
            request.setAttribute("dao", d);
            Accounts a = d.checkLogin(user, MaHoa.hashPassword(pass));
            if (a == null) {
                request.setAttribute("error", "Username or Password is not corrected!");
                request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
            } else {
                ses.setAttribute("account", a);
                String username = a.getUsername();
                Cookie userCookie = new Cookie("username", username);
                userCookie.setMaxAge(2 * 60 * 60 * 24);
                response.addCookie(userCookie);
                if (a.getIsAdmin() == 1) {
                    request.getRequestDispatcher("Views/Home.jsp").forward(request, response);
                }
                response.sendRedirect("HomeControl");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
