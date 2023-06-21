package servlet;

import dto.MovieDto;
import service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<MovieDto> list = MainService.getMainService().showMovieList();
        List<MovieDto> horrorList = MainService.getMainService().getGenre("공포");
        List<MovieDto> actionList = MainService.getMainService().getGenre("액션");

        req.setAttribute("movieList", list);
        req.setAttribute("horrorList", horrorList);
        req.setAttribute("actionList", actionList);

        req.getRequestDispatcher("views/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
