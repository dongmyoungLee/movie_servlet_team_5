package servlet;

import dto.MovieDto;
import service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        session을 열어준다
        HttpSession session = req.getSession();

        List<MovieDto> list = MainService.getMainService().showMovieList();
        List<MovieDto> horrorList = MainService.getMainService().getGenre("공포");
        List<MovieDto> actionList = MainService.getMainService().getGenre("액션");

        req.setAttribute("movieList", list);
        req.setAttribute("horrorList", horrorList);
        req.setAttribute("actionList", actionList);



//      #쿠키 조회
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("cookie")) {
                    String userIdEmail = cookie.getValue();
                    System.out.println(userIdEmail);
                    break;
                }

//                System.out.println("쿠키 이름: " + name + ", 값: " + userIdEmail);
            }
        }













        req.getRequestDispatcher("views/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
