package Controllers;

import DAL.DAO;
import Models.ProductOptions;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindControl extends HttpServlet {

    DAO d;

    @Override
    public void init() {
        d = new DAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int model = Integer.parseInt(request.getParameter("model"));
        int color = Integer.parseInt(request.getParameter("color"));
        int storage = Integer.parseInt(request.getParameter("storage"));
        ProductOptions list = d.selectDetail(model, color, storage);
        request.setAttribute("listO", list);
        request.getRequestDispatcher("Views/Find.jsp").forward(request, response);
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
