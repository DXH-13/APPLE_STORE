package Controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ValidateCode extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        int value = Integer.parseInt(request.getParameter("otp"));
        int otp = (int) ses.getAttribute("otp");
        String email = (String) ses.getAttribute("email");
        if (value == otp) {
//            request.setAttribute("email", request.getParameter("email"));
            ses.setAttribute("email", email);
            request.setAttribute("status", "success");
            request.getRequestDispatcher("Views/newPassword.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "wrong otp");
            request.getRequestDispatcher("Views/EnterOtp.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        service(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
