package at.techtitans.hackathon.servlet;

import at.techtitans.hackathon.entities.Employee;
import at.techtitans.hackathon.persistence.FeedbackDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String username = request.getParameter("uname");
        String password = request.getParameter("pword");

        if (FeedbackDAO.checkPassword(password, username)){
            Employee em = FeedbackDAO.getEmployeeByID(FeedbackDAO.getEmployeeIdByUsername(username));
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", em);
            response.sendRedirect(request.getContextPath() + "/login/success.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login/failed.jsp");
        }
    }
}
