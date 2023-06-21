package service;

import dao.MainDao;
import dto.MovieDto;

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

    public MovieDto findMovieBySeq(int seq) {
        return MainDao.getRepository().findMovieBySeq(seq);
    }

}
