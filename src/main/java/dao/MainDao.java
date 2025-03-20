package dao;

import config.JdbcConnection;
import dto.ActorDto;
import dto.MovieDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        String sql = "select * from main_movie where release_date < now() ORDER BY release_date ASC";

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
                movieDto.setDetail_text_image(resultSet.getString("detail_text_image"));

                movieDtoList.add(movieDto);

            }

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return movieDtoList;
    }

    public List<MovieDto> shownMovies() {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "select * from main_movie where release_date < now() ORDER BY release_date DESC;";

        List<MovieDto> shownMoviesList = new ArrayList<MovieDto>();


        try {
            PreparedStatement psmt = conn.prepareStatement(sql);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                // 새로운 객체 생성
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
                movieDto.setDetail_text_image(resultSet.getString("detail_text_image"));

                shownMoviesList.add(movieDto);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return shownMoviesList;
    }


    public int insertMainMovie(MovieDto movieDto) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into main_movie(title, release_date, duration, description, rating, genre, director, link, poster_image, text_image, detail_image, detail_text_image) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, movieDto.getTitle());
            psmt.setObject(2, movieDto.getRelease_date());
            psmt.setInt(3, movieDto.getDuration());
            psmt.setString(4, movieDto.getDescription());
            psmt.setString(5, movieDto.getRating());
            psmt.setString(6, movieDto.getGenre());
            psmt.setString(7, movieDto.getDirector());
            psmt.setString(8, movieDto.getLink());
            psmt.setString(9, movieDto.getPoster_image());
            psmt.setString(10, movieDto.getText_image());
            psmt.setString(11, movieDto.getDetail_image());
            psmt.setString(12, movieDto.getDetail_text_image());

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

    public int insertSubMovie(MovieDto movieDto) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "insert into sub_movie (title, release_date, duration, description, rating, genre, director, link, poster_image, text_image, detail_image) \n" +
                "values (? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, movieDto.getTitle());
            psmt.setObject(2, movieDto.getRelease_date());
            psmt.setInt(3, movieDto.getDuration());
            psmt.setString(4, movieDto.getDescription());
            psmt.setString(5, movieDto.getRating());
            psmt.setString(6, movieDto.getGenre());
            psmt.setString(7, movieDto.getDirector());
            psmt.setString(8, movieDto.getLink());
            psmt.setString(9, movieDto.getPoster_image());
            psmt.setString(10, movieDto.getText_image());
            psmt.setString(11, movieDto.getDetail_image());

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

    public List<MovieDto> getGenre(String genre){
        Connection conn = new JdbcConnection().getJdbc();
        String sql ="select * from sub_movie where genre = ?";

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
                                resultSet.getString("detail_image"),
                                resultSet.getString("detail_text_image")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return genrelist;
    }

    public MovieDto findMovieBySeq(int seq){
        Connection conn = new JdbcConnection().getJdbc();
        String sql ="select * from main_movie where movie_seq = ?";
        MovieDto movieDto = new MovieDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);

            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()){

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
                movieDto.setDetail_text_image(resultSet.getString("detail_text_image"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movieDto;
    }
    
    public MovieDto findSubMovieBySeq(int seq){
      Connection conn = new JdbcConnection().getJdbc();
      String sql ="select * from sub_movie where movie_seq = ?";
      MovieDto movieDto = new MovieDto();
      try {
          PreparedStatement psmt = conn.prepareStatement(sql);
          psmt.setInt(1, seq);
          ResultSet resultSet = psmt.executeQuery();
          while (resultSet.next()){
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
              movieDto.setDetail_text_image(resultSet.getString("detail_text_image"));
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return movieDto;
  }
    
  
    public List<ActorDto> movieSelectActor(int movieSeq) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "SELECT a.name\n" +
                "FROM main_movie AS m\n" +
                "INNER JOIN movie_actor AS ma ON m.movie_seq = ma.movie_seq\n" +
                "INNER JOIN actor AS a ON ma.actor_seq = a.actor_seq\n" +
                "WHERE m.movie_seq = ?;";

        List<ActorDto> actorDtoList = new ArrayList<ActorDto>();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, movieSeq);
            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                String actorName = resultSet.getString("name");

                ActorDto actorDto = new ActorDto();
                actorDto.setName(actorName);

                actorDtoList.add(actorDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actorDtoList;
    }

    public List<ActorDto> movieSubSelectActor(int movieSeq) {
        Connection conn = new JdbcConnection().getJdbc();

        String sql = "SELECT a.name\n" +
                "FROM sub_movie AS m\n" +
                "INNER JOIN sub_movie_actor AS ma ON m.movie_seq = ma.movie_seq\n" +
                "INNER JOIN actor AS a ON ma.actor_seq = a.actor_seq\n" +
                "WHERE m.movie_seq = ?;";

        List<ActorDto> actorDtoList = new ArrayList<ActorDto>();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, movieSeq);
            ResultSet resultSet = psmt.executeQuery();

            while (resultSet.next()) {
                String actorName = resultSet.getString("name");

                ActorDto actorDto = new ActorDto();
                actorDto.setName(actorName);

                actorDtoList.add(actorDto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actorDtoList;
    }


}
