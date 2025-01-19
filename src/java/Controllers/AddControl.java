package Controllers;

import DAL.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int product = Integer.parseInt(request.getParameter("product"));
        int color = Integer.parseInt(request.getParameter("color"));
        int storage = Integer.parseInt(request.getParameter("storage"));
        double price = Double.parseDouble(request.getParameter("price"));
        int promotion = Integer.parseInt(request.getParameter("promotion"));
        String image1 = request.getParameter("photo1");
        String image2 = request.getParameter("photo2");

        DAO d = new DAO();
        d.Insert(id, product, color, storage, price, promotion, image1, image2);
        response.sendRedirect("ManageControl");
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
