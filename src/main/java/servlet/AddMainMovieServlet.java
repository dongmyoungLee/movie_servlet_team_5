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
//        응답과 요청의 인코딩을 UTF-8로 설정합니다 -> 한국어로 처리하기 위해 필요함
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        MovieDto movieDto = new MovieDto();

//        Http의 요청에서 파라미터 값들을 가져온다.

        movieDto.setTitle(req.getParameter("title"));
//        Date 타입을 바로 적용할 수가 없어서 "0000-00-00"을 String의 형식으로 입력을 받은후 java.sql.Date타입으로 변환
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

//        AdminService에 있는 insertMainMovie를 호출하여 (movieDto)를 데이터에 삽입한다.
        AdminService.getMainService().insertMainMovie(movieDto);
//        해당 응답이 종료되면 sendRedirect로 인해 /adminMenu 이동한다
        resp.sendRedirect("/adminMenu");


    }
}
