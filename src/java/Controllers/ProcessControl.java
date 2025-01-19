package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Cart;
import Models.Item;
import Models.ProductOptions;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ProcessControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int id, num = 0;
        try {
            id = Integer.parseInt(id_raw);
            ProductOptions p = d.getProductOptionsByID(id);
            num = Integer.parseInt(num_raw);
            if (num == -1 && (cart.getQuantityById(id) <= 1)) {
                cart.removeItem(id);
            } else {
                int price = (int) p.getPrice();
                Item t = new Item(p, num, price);
                cart.addItem(t);
            }
        } catch (NumberFormatException e) {
        }
        List<Item> items = cart.getItems();
        txt = "";
        if (!items.isEmpty()) {
            txt = items.get(0).getProductOption().getProductOptionID() + ":"
                    + items.get(0).getQuantity();
        }
        for (int i = 1; i < items.size(); i++) {
            txt += "-" + items.get(i).getProductOption().getProductOptionID() + ":"
                    + items.get(i).getQuantity();
        }
        Cookie c = new Cookie(username + "_cart", txt);
        c.setMaxAge(2 * 60 * 60 * 24);
        response.addCookie(c);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("Views/CartDetail.jsp").forward(request, response);
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
                    response.addCookie(cookie);
                }
            }
        }
        String id = request.getParameter("id");
        String[] ids = txt.split("-");
        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");
            if (!s[0].equals(id)) {
                if (out.isEmpty()) {
                    out = ids[i];
                } else {
                    out += "-" + ids[i];
                }
            }
        }
        if (!out.isEmpty()) {
            Cookie c = new Cookie(username + "_cart", txt);
            c.setMaxAge(2 * 60 * 60 * 24);
            response.addCookie(c);
        }
        Cart cart = new Cart(out, list);
        request.setAttribute("cart", list);
        request.getRequestDispatcher("Views/CartDetail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
