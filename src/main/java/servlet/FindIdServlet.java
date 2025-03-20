package servlet;

import dao.UserDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login/findId.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("user_name");
        String phoneNumber = req.getParameter("user_phonenumber");
        UserDao userDao = new UserDao();
        UserDto userDto = userDao.findId(name, phoneNumber);


        if (userDto != null && userDto.getUser_id() != null) {
            req.setAttribute("id", userDto.getUser_id());
            req.getRequestDispatcher("views/login/showId.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "정보를 다시 확인해주세요");
            req.getRequestDispatcher("views/login/findId.jsp").forward(req, resp);
        }
    }
}