/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Paging;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PagingControl extends HttpServlet {

    DAO d;

    @Override
    public void init() {
        d = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        d.loadDB();
        request.setAttribute("dao", d);
        int nrpp = 12;
        try {
            nrpp = (int) (request.getAttribute("nrpp"));
        } catch (Exception e) {
        }
        int index = -1;
        try {
            index = Integer.parseInt(request.getAttribute("index") + "");
        } catch (NumberFormatException e) {

        }
        Paging p = new Paging(nrpp, index, d.getProdop().size());
        p.calc();
        request.setAttribute("page", p);
        request.setAttribute("nrppArr", nrppArr);
        request.getRequestDispatcher("Views/Store.jsp").forward(request, response);
    }
    int[] nrppArr = {12, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 20, 30, 50, 100, 200, 500, 1000, 5000};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        int totalPage = Integer.parseInt(request.getParameter("totalPage"));
        if (request.getParameter("btnHome") != null) {
            index = 0;
        }
        if (request.getParameter("btnEnd") != null) {
            index = totalPage;
        }
        if (request.getParameter("btnPre") != null) {
            index -= 1;
        }
        if (request.getParameter("btnNext") != null) {
            index += 1;
        }
        for (int i = 0; i < totalPage; i++) {
            if (request.getParameter("btn" + i) != null) {
                index = i;
            }
        }
        int nrpp = Integer.parseInt(request.getParameter("nrpp"));
        request.setAttribute("nrpp", nrpp);
        request.setAttribute("index", index);
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
