package at.techtitans.hackathon.servlet;

import java.io.*;

import at.techtitans.hackathon.entities.Employee;
import at.techtitans.hackathon.persistence.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "feedback", value = "/feedback")
public class feedbackServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String recipient = request.getParameter("recipient");
        String performance = request.getParameter("performance");
        String knowledge = request.getParameter("knowledge");
        String communication = request.getParameter("communication");
        String reliability = request.getParameter("reliability");
        String teamwork = request.getParameter("teamwork");
        String adaptability = request.getParameter("adability");
        String feedback = request.getParameter("feedback");
        String leadership = request.getParameter("leadership");
        boolean anonymous = request.getParameter("anonymous") != null;

        int fromid  = -1;

        if(!anonymous){
            HttpSession session = request.getSession();
            Employee loggedInEmployee = (Employee) session.getAttribute("loggedInUser");
            fromid = loggedInEmployee.getId();
        }

        FeedbackDAO.setNewUserFeedback(Integer.parseInt(recipient),fromid,Integer.parseInt(performance),Integer.parseInt(knowledge),Integer.parseInt(communication),Integer.parseInt(reliability),Integer.parseInt(teamwork),Integer.parseInt(adaptability),Integer.parseInt(leadership),feedback,anonymous);
    }


}