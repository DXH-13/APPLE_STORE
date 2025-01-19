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

public class UpdatePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/UpdatePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        String username = request.getParameter("username");
        String cpassword = request.getParameter("cpassword");
        String npassword = request.getParameter("npassword");
        String rpassword = request.getParameter("rpassword");
        if (username == null || cpassword == null) {
            cpassword = "123";
        }
        try {
            Accounts a = d.checkLogin(username, MaHoa.hashPassword(cpassword));
            if (a == null) {
//                String msg = "Old password is incorrect!";
//                request.setAttribute("msg", msg);
            } else if (!npassword.equals(rpassword)) {
                String msg = "New passwords do not match!";
                request.setAttribute("msg", msg);
            } else {
                Accounts ac = d.UpdatePassword(username, MaHoa.hashPassword(npassword));
                HttpSession ses = request.getSession();
                ses.setAttribute("account", ac);
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        request.setAttribute("cpassword", cpassword);
        request.setAttribute("npassword", npassword);
        request.setAttribute("rpassword", rpassword);
        request.getRequestDispatcher("Profile").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
