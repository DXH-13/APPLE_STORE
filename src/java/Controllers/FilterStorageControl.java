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

public class FilterStorageControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        List<ProductOptions> listPO = d.getAll();
        request.setAttribute("listPO", listPO);
        List<Products> listP = d.getAllProducts();
        request.setAttribute("listP", listP);
        List<Color> listCl = d.getAllColor();
        request.setAttribute("listCl", listCl);
        List<Storage> listS = d.getAllStorage();
        request.setAttribute("listS", listS);
        int sid = Integer.parseInt(request.getParameter("sid"));
        List<ProductOptions> listSs = d.getAllByStorage(sid);
        request.setAttribute("listPO", listSs);
        request.getRequestDispatcher("Views/Store.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
