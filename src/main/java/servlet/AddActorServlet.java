package servlet;

import dto.ActorDto;
import dto.MovieDto;
import service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/admin/addActor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        ActorDto actorDto = new ActorDto();

        actorDto.setName(req.getParameter("name"));
        java.sql.Date releaseDate = java.sql.Date.valueOf(req.getParameter("birth_date"));
        actorDto.setBirth_date(releaseDate);
        actorDto.setNation(req.getParameter("nation"));
        actorDto.setGender(req.getParameter("gender"));



        AdminService.getMainService().insertActor(actorDto);
        resp.sendRedirect("/adminMenu");


    }
}
