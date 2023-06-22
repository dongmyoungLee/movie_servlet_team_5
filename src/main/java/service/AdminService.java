package service;

import dao.ActorDao;
import dao.MainDao;
import dto.ActorDto;
import dto.MovieDto;

import java.util.List;

public class AdminService {
    private static AdminService adminService;
    public static AdminService getMainService() {
        if(adminService == null) adminService = new AdminService();
        return adminService;
    }

//        AddMainMovieServlet에서 받아온 (movieDto)를 다시 MainDao에 있는 insertMainMovie로 데이터를 삽입한다.
    public void insertMainMovie(MovieDto movieDto){
        MainDao.getRepository().insertMainMovie(movieDto);
    }

    public void insertSubMovie(MovieDto movieDto){
        MainDao.getRepository().insertSubMovie(movieDto);
    }

    public void insertActor(ActorDto actorDto){
        ActorDao.getRepository().insertActor(actorDto);
    }

    public List<MovieDto> shownMovieList(){
        List<MovieDto> movieList = MainDao.getRepository().shownMovies();
        return movieList;
    }

    public List<ActorDto> actorDtoList(){
        List<ActorDto> actorList = ActorDao.getRepository().actorList();
        return actorList;
    }

    public void insertMovieActor(int movie_seq, int actor_seq){
        ActorDao.getRepository().insertMovieActor(movie_seq, actor_seq);
    }

    public List<ActorDto> movieSelectActor(int movieSeq){
        return MainDao.getRepository().movieSelectActor(movieSeq);
    }


}
