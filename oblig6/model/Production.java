package no.hiof.haakonka.obligOOP.model;


import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Production {
    /**
     * This class is a superclass and it has seven field variables with getters and setter for each one.
     * One is a list of roles and the rest is information regarding an episode or season.
     * It has three constructors in case some information is lacking.
     */
    protected  ArrayList<Role> roles = new ArrayList<>();
    protected int playTime;
    protected LocalDate releaseDate;
    protected String description;
    protected String title;
    protected String url;
    protected Person director;


    public Production(String title, int playTime, LocalDate releaseDate, String description, String url) {
        this.title = title;
        this.playTime = playTime;
        this.releaseDate = releaseDate;
        this.description = description;
        this.url = url;
    }

    public Production(String title, int playTime, LocalDate releaseDate, String description) {
        this.title = title;
        this.playTime = playTime;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Production(String title, LocalDate releaseDate, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    /**
     * @return This method overrides the toString method and returns the values of the field variables.
     */
    @Override
    public String toString() {
        return "Production{" +
                "roles=" + roles +
                ", playTime=" + playTime +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", director=" + director +
                '}';
    }
}
