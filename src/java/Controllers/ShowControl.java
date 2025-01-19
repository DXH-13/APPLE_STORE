package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Cart;
import Models.ProductOptions;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ShowControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        d.loadDB();
        request.setAttribute("dao", d);
        List<ProductOptions> list = d.getAll();
        Cookie[] arr = request.getCookies();
        HttpSession ses = request.getSession();
        Accounts account = (Accounts) ses.getAttribute("account");
        String txt = "";
        String username = account.getUsername();
        if (arr != null) {
            for (Cookie cookie : arr) {
                if (cookie.getName().equals(username + "_cart")) {
                    txt += cookie.getValue();
                    response.addCookie(cookie);
                }
            }
        }

        Cart cart = new Cart(txt, list);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("Views/CartDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";

    }
}
