package servlet;

import chatGPT.ChatGPTMovieRecommendation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;


public class AiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/ai.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userInput = req.getParameter("text");

        String chatGptResponse = new ChatGPTMovieRecommendation().sendChatGptRequest(userInput);
        System.out.println(chatGptResponse);
        String[] chatGptReply = new ChatGPTMovieRecommendation().extractChatGptReply(chatGptResponse);

        HttpSession session = req.getSession();
        session.setAttribute("ai_result",chatGptReply);

        resp.sendRedirect("/aiResult");
    }
}
