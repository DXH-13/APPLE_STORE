package Controllers;

import DAL.DAO;
import Models.Cart;
import Models.Categories;
import Models.Color;
import Models.Item;
import Models.ProductOptions;
import Models.Products;
import Models.Reviews;
import Models.Storage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class StoreControl extends HttpServlet {

    DAO d;

    public void init() {
        d = new DAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        d.loadDB();
        request.setAttribute("dao", d);
        int count = d.countProduct();
        int endPage = count / 12;
        if (count % 12 != 0) {
            endPage++;
        }
        List<ProductOptions> paging = d.offsetCount(index);
        request.setAttribute("listPO", paging);
        request.setAttribute("end", endPage);
//        List<ProductOptions> listPO = d.getAll();
//        request.setAttribute("listPO", listPO);
        List<Products> listP = d.getAllProducts();
        request.setAttribute("listP", listP);
        List<Color> listCl = d.getAllColor();
        request.setAttribute("listCl", listCl);
        List<Storage> listS = d.getAllStorage();
        request.setAttribute("listS", listS);
        List<Categories> listC = d.getAllCategories();
        request.setAttribute("listC", listC);
        List<ProductOptions> list = d.getAll();

        String accountID = request.getParameter("accountID");
        String comment = request.getParameter("comment");
        List<Reviews> listr = d.getReviews();
        request.setAttribute("listR", listr);
        d.insertReviews(accountID, comment);

        Cookie[] arr = request.getCookies();
        String txt = "";
        String username = "";
        if (arr != null) {
            for (Cookie cookie : arr) {
                if (cookie.getName().equals("cart")) {
                    txt += cookie.getValue();
                }
            }
        }
        Cart cart = new Cart(txt, list);
        List<Item> listItem = cart.getItems();
        int n;
        if (listItem != null) {
            n = listItem.size();
        } else {
            n = 0;
        }
        request.setAttribute("size", n);
        request.setAttribute("data", list);
        request.getRequestDispatcher("Views/Store.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
