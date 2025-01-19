package Controllers;

import DAL.DAO;
import Models.Accounts;
import Utils.MaHoa;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

public class NewPass extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        DAO d = new DAO();
        String email = request.getParameter("email");
        String npassword = request.getParameter("npassword");
        String rpassword = request.getParameter("rpassword");
        try {
            if (!npassword.equals(rpassword)) {
                String msg = "New passwords do not match!";
                request.setAttribute("msg", msg);
            } else {
                Accounts ac = d.ForgetPass(MaHoa.hashPassword(npassword), email);
                ses.setAttribute("account", ac);
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        request.getRequestDispatcher("Views/newPassword.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
