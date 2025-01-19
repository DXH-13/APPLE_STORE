package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Cart;
import Models.Customers;
import Models.Order;
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

public class CheckOutControl extends HttpServlet {

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
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        Cart cart = new Cart(txt, list);
        int totalMoney = cart.getTotalMoney();
        double money = account.getMoney();
        if (totalMoney > money) {
            request.getRequestDispatcher("Views/Block.jsp").forward(request, response);
        } else {
            money -= totalMoney;
            account.setMoney(money);
            d.updateUserMoney(account);
            d.stonk(totalMoney);
            d.addOrder(account, cart);
            Cookie c = new Cookie("cart", "");
            c.setMaxAge(0);
            response.addCookie(c);
            request.getRequestDispatcher("Complete").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
