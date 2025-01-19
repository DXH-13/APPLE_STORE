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

public class SearchControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        DAO d = new DAO();
        List<ProductOptions> listPO = d.getAll();
        request.setAttribute("listPO", listPO);
        List<Products> listP = d.getAllProducts();
        request.setAttribute("listP", listP);
        List<Color> listCl = d.getAllColor();
        request.setAttribute("listCl", listCl);
        List<Storage> listS = d.getAllStorage();
        request.setAttribute("listS", listS);
        List<ProductOptions> list = d.searchByName(txtSearch);
        request.setAttribute("listPO", list);
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
