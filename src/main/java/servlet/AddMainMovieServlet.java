package servlet;

import dao.MainDao;
import dto.MovieDto;
import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class AddMainMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/admin/addMovie.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        MovieDto movieDto = new MovieDto();

        movieDto.setTitle(req.getParameter("title"));

        java.sql.Date releaseDate = java.sql.Date.valueOf(req.getParameter("release_date"));
        movieDto.setRelease_date(releaseDate);

        movieDto.setDuration(Integer.parseInt(req.getParameter("duration")));
        movieDto.setDescription(req.getParameter("description"));
        movieDto.setRating(req.getParameter("rating"));
        movieDto.setGenre(req.getParameter("genre"));
        movieDto.setDirector(req.getParameter("director"));
        movieDto.setLink(req.getParameter("link"));
        movieDto.setPoster_image(req.getParameter("poster_image"));
        movieDto.setText_image(req.getParameter("text_image"));
        movieDto.setDetail_image(req.getParameter("detail_image"));
        movieDto.setDetail_text_image(req.getParameter("detail_text_image"));

        AdminService.getMainService().insertMainMovie(movieDto);
        resp.sendRedirect("/adminMenu");


    }
}
