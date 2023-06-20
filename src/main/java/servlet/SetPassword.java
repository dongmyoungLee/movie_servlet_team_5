package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetPassword {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("name", req.getParameter("id"));
        req.setAttribute("phonenumber", req.getParameter("phonenumber"));
        req.getRequestDispatcher("/views/findPassword.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int password = Integer.parseInt(req.getParameter("password"));
        new UserDao().update(password);
        resp.sendRedirect("/login");

    }
}