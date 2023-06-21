package dao;

import config.JdbcConnection;
import dto.MovieDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainDao {
    private static MainDao dao;
    public static MainDao getRepository() {
        if(dao == null) dao = new MainDao();
        return dao;
    }

    public List<MovieDto> mainMovieList(){
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select * from movie;";

        List<MovieDto> movieDtoList = new ArrayList<MovieDto>();


        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()){
                MovieDto movieDto = new MovieDto();

                movieDto.setMovie_seq(resultSet.getInt("movie_seq"));
                movieDto.setTitle(resultSet.getString("title"));
                movieDto.setRelease_date(resultSet.getDate("release_date"));
                movieDto.setDuration(resultSet.getInt("duration"));
                movieDto.setDescription(resultSet.getString("description"));
                movieDto.setRating(resultSet.getString("rating"));
                movieDto.setGenre(resultSet.getString("genre"));
                movieDto.setDirector(resultSet.getString("director"));
                movieDto.setLink(resultSet.getString("link"));
                movieDto.setPoster_image(resultSet.getString("poster_image"));
                movieDto.setText_image(resultSet.getString("text_image"));
                movieDto.setDetail_image(resultSet.getString("detail_image"));

                movieDtoList.add(movieDto);

            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return movieDtoList;
    }

    public List<MovieDto> getGenre(String genre){
        Connection conn = new JdbcConnection().getJdbc();
        String sql ="select * from movie where genre = ?";

        List<MovieDto> genrelist = new ArrayList<MovieDto>();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, genre);

            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()){
                genrelist.add(
                        new MovieDto(
                                resultSet.getInt("movie_seq"),
                                resultSet.getString("title"),
                                resultSet.getDate("release_date"),
                                resultSet.getInt("duration"),
                                resultSet.getString("description"),
                                resultSet.getString("rating"),
                                resultSet.getString("genre"),
                                resultSet.getString("director"),
                                resultSet.getString("link"),
                                resultSet.getString("poster_image"),
                                resultSet.getString("text_image"),
                                resultSet.getString("detail_image")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(genrelist);
        return genrelist;
    }



}
