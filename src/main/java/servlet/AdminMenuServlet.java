package servlet;

import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("actor_seq") != null){
            int actor_seq = Integer.parseInt(req.getParameter("actor_seq"));
            String seqParam = (String) session.getAttribute("movie_seq");
            int movie_seq = Integer.parseInt(seqParam);
            AdminService.getMainService().insertMovieActor(movie_seq, actor_seq);
        }
        req.getRequestDispatcher("views/admin/adminMenu.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
