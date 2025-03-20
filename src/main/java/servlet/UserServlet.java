package servlet;

import dao.UserDao;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");
        String userBirthdate = req.getParameter("userBirthdate");
        String userPhonenumber = req.getParameter("userPhonenumber");
        UserDto userDto = new UserDto();

        userDto.setUser_id(userId);
        userDto.setUser_name(userName);
        userDto.setUser_email(userEmail);
        userDto.setUser_pwd(userPwd);
        userDto.setUser_birthdate(userBirthdate);
        userDto.setUser_phone_number(userPhonenumber);

        UserDao userDao = new UserDao();

        if(userDao.signUp(userDto)){
            HttpSession session = req.getSession();
            session.setAttribute("uname", userDto.getUser_name());
            session.setAttribute("uid", userDto.getUser_id());
            resp.sendRedirect("/login");
        }else{
            resp.sendRedirect("/signup");
        }
    }
}

