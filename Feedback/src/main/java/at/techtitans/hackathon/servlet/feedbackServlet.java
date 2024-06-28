package at.techtitans.hackathon.servlet;

import java.io.*;

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
        boolean anonymous = request.getParameter("anonymous") != null;

        // Process the received data (you can save it to a database or perform other actions here)

        // For demonstration, let's print the received data to console
        System.out.println("Feedback submitted:");
        System.out.println("Recipient: " + recipient);
        System.out.println("Performance: " + performance);
        System.out.println("Knowledge: " + knowledge);
        System.out.println("Communication: " + communication);
        System.out.println("Reliability: " + reliability);
        System.out.println("Teamwork: " + teamwork);
        System.out.println("Adaptability: " + adaptability);
        System.out.println("Feedback: " + feedback);
        System.out.println("Anonymous: " + anonymous);
    }
}