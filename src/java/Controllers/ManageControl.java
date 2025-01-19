package Controllers;

import DAL.DAO;
import Models.Color;
import Models.ProductOptions;
import Models.Products;
import Models.Storage;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageControl extends HttpServlet {

    DAO d;

    @Override
    public void init() {
        d = new DAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductOptions> listPO = d.getAll();
        request.setAttribute("listPO", listPO);
        List<Products> listP = d.getAllProducts();
        request.setAttribute("listP", listP);
        List<Color> listCl = d.getAllColor();
        request.setAttribute("listCl", listCl);
        List<Storage> listS = d.getAllStorage();
        request.setAttribute("listS", listS);
        Object obj = request.getParameter("type");
        Object o2 = request.getParameter("id");
        if (obj != null) {
            if ((obj + "").equals("0")) {
                if (o2 != null) {
                    request.setAttribute("update", o2 + "");
                } else {
                    request.removeAttribute("update");
                }
            }
            if ((obj + "").equals("1")) {
                if (o2 != null) {
                    d.Delete(o2 + "");
                }
            }
        }
        request.setAttribute("dao", d);
        request.getRequestDispatcher("Views/Manage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object o1 = request.getParameter("btnInsert");
        Object o2 = request.getParameter("btnUpdate");
        int productOptionID = Integer.parseInt(request.getParameter("productOptionID"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        int colorID = Integer.parseInt(request.getParameter("colorID"));
        int storageTypeID = Integer.parseInt(request.getParameter("storageTypeID"));
        double price = Double.parseDouble(request.getParameter("price"));
        int promotionID = Integer.parseInt(request.getParameter("promotionID"));
        String photo1 = request.getParameter("photo1");
        String photo2 = request.getParameter("photo2");
        boolean checkUpdate = false;
        for (ProductOptions p : d.getProdop()) {
            if (p.getProductOptionID() == (productOptionID)) {
                checkUpdate = true;
                break;
            } else {
            }
        }
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
