package servlet;

import com.mysql.cj.jdbc.JdbcConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FindIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login/findId.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = new JdbcConnection().getJdbc();
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");

        String id = "findId";

        try (
             PreparedStatement stmt = conn.prepareStatement("SELECT id FROM users WHERE name = ? AND phone_number = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, phoneNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getString("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        req.setAttribute("id", id);

        req.getRequestDispatcher("views/login/showId.jsp").forward(req, resp);
    }