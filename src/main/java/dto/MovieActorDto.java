package dto;

public class MovieActorDto {
    private int movie_seq;
    private int actor_seq;

    public MovieActorDto(int movie_seq, int actor_seq) {
        this.movie_seq = movie_seq;
        this.actor_seq = actor_seq;
    }

    public MovieActorDto() {
    }

    public int getMovie_seq() {
        return movie_seq;
    }

    public void setMovie_seq(int movie_seq) {
        this.movie_seq = movie_seq;
    }

    public int getActor_seq() {
        return actor_seq;
    }

    public void setActor_seq(int actor_seq) {
        this.actor_seq = actor_seq;
    }
}
