package servlet;

import dto.MovieDto;
import service.AdminService;
import service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DetailSubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int seq = Integer.parseInt(req.getParameter("seq"));

        MovieDto movie = MainService.getMainService().findSubMovieBySeq(seq);

        session.setAttribute("subActorList", AdminService.getMainService().movieSubSelectActor(movie.getMovie_seq()));
        session.setAttribute("movie", movie);

        req.getRequestDispatcher("views/subDetail.jsp").forward(req,resp);
    }
}
