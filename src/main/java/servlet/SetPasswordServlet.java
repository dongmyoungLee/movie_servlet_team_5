package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login/setPassword.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        if (!newPassword.equals(confirmPassword)) {
            req.setAttribute("errorMessage", "신규 비밀번호와 신규 비밀번호 재입력이 \n일치하지 않습니다.");
            req.getRequestDispatcher("views/login/setPassword.jsp").forward(req, resp);
        } else {
            UserDao.updatePassword(userId, newPassword);
            req.getRequestDispatcher("views/login/login.jsp").forward(req, resp);
        }
    }
}