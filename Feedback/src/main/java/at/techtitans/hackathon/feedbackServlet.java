package at.techtitans.hackathon;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "feedbackservlet", value = "/feedback")
public class feedbackServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"de\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Feedback</title>");
        out.println("<style>");
        out.println("body { margin: 0; font-family: Arial, sans-serif; background-color: #333; color: white; display: flex; justify-content: center; align-items: center; height: 100vh; }");
        out.println(".feedback-container { background: #444; padding: 40px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 400px; text-align: center; position: relative; }");
        out.println(".user-profile { position: absolute; top: 20px; right: 20px; cursor: pointer; }");
        out.println(".user-profile img { width: 40px; height: 40px; border-radius: 50%; }");
        out.println(".user-info { display: none; position: absolute; top: 70px; right: 20px; background: #555; padding: 20px; border-radius: 8px; width: 200px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }");
        out.println(".user-info p { margin: 10px 0; }");
        out.println(".feedback-container h2 { margin-bottom: 20px; color: white; }");
        out.println(".input-field, .text-input-field, .select-field { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #888; border-radius: 4px; box-sizing: border-box; background: #555; color: white; }");
        out.println(".stars { display: flex; flex-direction: row-reverse; justify-content: center; margin: 10px 0; }");
        out.println(".stars input[type=\"radio\"] { display: none; }");
        out.println(".stars label { font-size: 24px; color: #ccc; cursor: pointer; transition: color 0.2s; }");
        out.println(".stars label:hover, .stars label:hover ~ label, .stars input[type=\"radio\"]:checked ~ label { color: #ffcc00; }");
        out.println(".submit-btn { width: 100%; padding: 10px; background-color: #cc0033; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }");
        out.println(".submit-btn:hover { background-color: #a30026; }");
        out.println(".checkbox-container { display: flex; align-items: center; justify-content: center; }");
        out.println(".checkbox-container input { margin-right: 10px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"feedback-container\">");
        out.println("<div class=\"user-profile\" onclick=\"toggleUserInfo()\">");
        out.println("<img src=\"https://via.placeholder.com/40\" alt=\"User\">");
        out.println("</div>");
        out.println("<div class=\"user-info\" id=\"user-info\">");
        out.println("<p>Name: Max Mustermann</p>");
        out.println("<p>Email: max@beispiel.com</p>");
        out.println("</div>");
        out.println("<h2>Feedback</h2>");
        out.println("<form>");
        out.println("<select class=\"select-field\">");
        out.println("<option value=\"\">Wählen Sie einen Empfänger</option>");
        out.println("<option value=\"user1\">Benutzer 1</option>");
        out.println("<option value=\"user2\">Benutzer 2</option>");
        out.println("</select>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Work Performance:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"performance-star5\" name=\"performance\" value=\"5\"><label for=\"performance-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"performance-star4\" name=\"performance\" value=\"4\"><label for=\"performance-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"performance-star3\" name=\"performance\" value=\"3\"><label for=\"performance-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"performance-star2\" name=\"performance\" value=\"2\"><label for=\"performance-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"performance-star1\" name=\"performance\" value=\"1\"><label for=\"performance-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Knowledge:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"knowledge-star5\" name=\"knowledge\" value=\"5\"><label for=\"knowledge-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"knowledge-star4\" name=\"knowledge\" value=\"4\"><label for=\"knowledge-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"knowledge-star3\" name=\"knowledge\" value=\"3\"><label for=\"knowledge-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"knowledge-star2\" name=\"knowledge\" value=\"2\"><label for=\"knowledge-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"knowledge-star1\" name=\"knowledge\" value=\"1\"><label for=\"knowledge-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Communication:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"communication-star5\" name=\"communication\" value=\"5\"><label for=\"communication-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"communication-star4\" name=\"communication\" value=\"4\"><label for=\"communication-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"communication-star3\" name=\"communication\" value=\"3\"><label for=\"communication-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"communication-star2\" name=\"communication\" value=\"2\"><label for=\"communication-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"communication-star1\" name=\"communication\" value=\"1\"><label for=\"communication-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Reliability:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"reliability-star5\" name=\"reliability\" value=\"5\"><label for=\"reliability-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"reliability-star4\" name=\"reliability\" value=\"4\"><label for=\"reliability-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"reliability-star3\" name=\"reliability\" value=\"3\"><label for=\"reliability-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"reliability-star2\" name=\"reliability\" value=\"2\"><label for=\"reliability-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"reliability-star1\" name=\"reliability\" value=\"1\"><label for=\"reliability-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Teamwork:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"teamwork-star5\" name=\"teamwork\" value=\"5\"><label for=\"teamwork-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"teamwork-star4\" name=\"teamwork\" value=\"4\"><label for=\"teamwork-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"teamwork-star3\" name=\"teamwork\" value=\"3\"><label for=\"teamwork-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"teamwork-star2\" name=\"teamwork\" value=\"2\"><label for=\"teamwork-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"teamwork-star1\" name=\"teamwork\" value=\"1\"><label for=\"teamwork-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Adability:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"adability-star5\" name=\"adability\" value=\"5\"><label for=\"adability-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"adability-star4\" name=\"adability\" value=\"4\"><label for=\"adability-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"adability-star3\" name=\"adability\" value=\"3\"><label for=\"adability-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"adability-star2\" name=\"adability\" value=\"2\"><label for=\"adability-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"adability-star1\" name=\"adability\" value=\"1\"><label for=\"adability-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"feedback-field\">");
        out.println("<label>Leadership:</label>");
        out.println("<div class=\"stars\">");
        out.println("<input type=\"radio\" id=\"leadership-star5\" name=\"leadership\" value=\"5\"><label for=\"leadership-star5\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"leadership-star4\" name=\"leadership\" value=\"4\"><label for=\"leadership-star4\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"leadership-star3\" name=\"leadership\" value=\"3\"><label for=\"leadership-star3\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"leadership-star2\" name=\"leadership\" value=\"2\"><label for=\"leadership-star2\">&#9733;</label>");
        out.println("<input type=\"radio\" id=\"leadership-star1\" name=\"leadership\" value=\"1\"><label for=\"leadership-star1\">&#9733;</label>");
        out.println("</div>");
        out.println("</div>");
        out.println("<textarea placeholder=\"Geben Sie Ihr Feedback ein...\" class=\"text-input-field\"></textarea>");
        out.println("<div class=\"checkbox-container\">");
        out.println("<input type=\"checkbox\" id=\"anonymous\" name=\"anonymous\" checked>");
        out.println("<label for=\"anonymous\">Feedback anonym abgeben</label>");
        out.println("</div>");
        out.println("<button type=\"submit\" class=\"submit-btn\">Absenden</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("<script>");
        out.println("function toggleUserInfo() { var userInfo = document.getElementById('user-info'); if (userInfo.style.display === 'none' || userInfo.style.display === '') { userInfo.style.display = 'block'; } else { userInfo.style.display = 'none'; } }");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}