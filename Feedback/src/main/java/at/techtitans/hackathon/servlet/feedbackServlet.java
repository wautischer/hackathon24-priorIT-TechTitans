package at.techtitans.hackathon.servlet;

import at.techtitans.hackathon.entities.Employee;
import at.techtitans.hackathon.persistence.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

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
        String fromID = request.getParameter("fromID").strip();
        boolean anonymous = request.getParameter("anonymous") != null;


        int fID = -1;
        if (!anonymous) {
            fID = Integer.parseInt(fromID);
        }

        FeedbackDAO.setNewUserFeedback(
                Integer.parseInt(recipient),
                fID,
                Integer.parseInt(performance),
                Integer.parseInt(knowledge),
                Integer.parseInt(communication),
                Integer.parseInt(reliability),
                Integer.parseInt(teamwork),
                Integer.parseInt(adaptability),
                Integer.parseInt(leadership),
                feedback);

        // Redirect to a success page or handle response as needed
        response.sendRedirect("index.jsp");
    }
}

