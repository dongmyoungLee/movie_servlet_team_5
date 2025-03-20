package dao;

import config.JdbcConnection;
import dto.ActorDto;
import dto.MovieDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDao {
    private static ActorDao actorDao;
    public static ActorDao getRepository() {
        if(actorDao == null) actorDao = new ActorDao();
        return actorDao;
    }

    public int insertActor(ActorDto actorDto){
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "INSERT INTO actor (name, birth_date, nation, gender)\n" +
                "values (?, ?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, actorDto.getName());
            psmt.setObject(2, actorDto.getBirth_date());
            psmt.setString(3, actorDto.getNation());
            psmt.setString(4, actorDto.getGender());

            if (psmt.executeUpdate() == 0) {
                return 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public void insertMovieActor(int movie_seq, int actor_seq){
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into movie_actor values (?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, movie_seq);
            psmt.setInt(2, actor_seq);

            psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<ActorDto> actorList(){
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select * from actor;";

        List<ActorDto> actorlist = new ArrayList<ActorDto>();


        try {
            PreparedStatement psmt = conn.prepareStatement(sql);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                // 새로운 객체 생성
                ActorDto actorDto = new ActorDto();

                actorDto.setActor_seq(resultSet.getInt("actor_seq"));
                actorDto.setName(resultSet.getString("name"));
                actorDto.setBirth_date(resultSet.getDate("birth_date"));
                actorDto.setNation(resultSet.getString("nation"));
                actorDto.setGender(resultSet.getString("gender"));

                actorlist.add(actorDto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return actorlist;

    }


}
