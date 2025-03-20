package dto;

import java.util.Date;

public class MovieDto {
    private int movie_seq;
    private String title;
    private Date release_date;
    private int duration;
    private String description;
    private String rating;
    private String genre;
    private String director;
    private String link;
    private String poster_image;
    private String text_image;
    private String detail_image;
    private String detail_text_image;

    public MovieDto() {
    }

    public MovieDto(int movie_seq, String title, Date release_date, int duration, String description, String rating, String genre, String director, String link, String poster_image, String text_image, String detail_image, String detail_text_image) {
        this.movie_seq = movie_seq;
        this.title = title;
        this.release_date = release_date;
        this.duration = duration;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.link = link;
        this.poster_image = poster_image;
        this.text_image = text_image;
        this.detail_image = detail_image;
        this.detail_text_image = detail_text_image;
    }

    public int getMovie_seq() {
        return movie_seq;
    }

    public void setMovie_seq(int movie_seq) {
        this.movie_seq = movie_seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPoster_image() {
        return poster_image;
    }

    public void setPoster_image(String poster_image) {
        this.poster_image = poster_image;
    }

    public String getText_image() {
        return text_image;
    }

    public void setText_image(String text_image) {
        this.text_image = text_image;
    }

    public String getDetail_image() {
        return detail_image;
    }

    public void setDetail_image(String detail_image) {
        this.detail_image = detail_image;
    }

    public String getDetail_text_image() {
        return detail_text_image;
    }

    public void setDetail_text_image(String detail_text_image) {
        this.detail_text_image = detail_text_image;
    }
}
