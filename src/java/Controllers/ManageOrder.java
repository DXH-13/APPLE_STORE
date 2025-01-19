package Controllers;

import DAL.DAO;
import Models.Accounts;
import Models.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageOrder extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO d = new DAO();
        List<Order> list = d.getOrder();
        request.setAttribute("listO", list);
        int soLuongDonHang = d.countOrdersForAccounts();
        double moneyForAdmin = d.getMoneyForAdminAccounts();
        Accounts ah = d.getTopAccountWithHighestMoney();
        request.setAttribute("ah", ah);
        request.setAttribute("sl", soLuongDonHang);
        request.setAttribute("mn", moneyForAdmin);
        request.getRequestDispatcher("Views/ManageOrder.jsp").forward(request, response);
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
