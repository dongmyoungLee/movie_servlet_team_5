package service;

import dao.MainDao;
import dao.UserDao;
import dto.MovieDto;
import dto.UserDto;

import java.util.List;

public class MainService {
    private static MainService mainService;
    public static MainService getMainService() {
        if(mainService == null) mainService = new MainService();
        return mainService;
    }

    public List<MovieDto> showMovieList() {
        List<MovieDto> movieList = MainDao.getRepository().mainMovieList();
        return movieList;
    }

    public List<MovieDto> getGenre(String genre) {
        List<MovieDto> getGenreList = MainDao.getRepository().getGenre(genre);
        return getGenreList;
    }
    public UserDto loginById(String user_id, String user_pwd){
        UserDto loginIdlUser = UserDao.getUserRepository().loginById(user_id, user_pwd);
        return loginIdlUser;
    }
    public UserDto loginByEmail(String user_email, String user_pwd){
        UserDto loginEmailUser = UserDao.getUserRepository().loginById(user_email, user_pwd);
        return loginEmailUser;
    }


    public MovieDto findMovieBySeq(int seq) {
        return MainDao.getRepository().findMovieBySeq(seq);
    }

    public MovieDto findSubMovieBySeq(int seq) {
        return MainDao.getRepository().findSubMovieBySeq(seq);
    }


}
