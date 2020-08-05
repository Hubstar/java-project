package no.hiof.haakonka.obligOOP.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class TvSeries implements Comparable<TvSeries> {
    /**
     * This class implements the Comparable contract. It has seven field variables: Two lists, one for episodes and one for series.
     * The other field variables are related to information
     * about each episode.
     */
    protected ArrayList<Episode> episodeArrayList = new ArrayList<>();
    private int averagePlayTime;
    private int numberOfSeasons = 1;
    private LocalDate releaseDate;
    private String title;
    private String description;
    protected static ArrayList<TvSeries> tvSeriesArrayList = new ArrayList<>();

    /**
     * @return This method aquires a list with roles that play in an episode.
     */
    public ArrayList<Role> getCast() {
        ArrayList<Role> listeMedRoller = new ArrayList<>();
        for (Episode anEpisode : episodeArrayList) {
            anEpisode.getRoles().forEach(listeMedRoller::add);
        }
        return listeMedRoller;
    }

    /**
     * @param episode This method adds an episode to the episode list if the season number is greater or equal to the current season.
     */
    public void addEpisode(Episode episode) {
        if(episode.getSeason() <= numberOfSeasons+1) {
            numberOfSeasons = episode.getSeason();
            this.episodeArrayList.add(episode);
            updateAveragePlayTime();
        }
        else {
            System.out.println("Unable to add episode");
        }
    }

    /**
     *
     * @param oensketSesong This method lets the user choose a season.
     * @return It returns the a list with the chosen season.
     */
    public ArrayList<Episode> velgSesong(int oensketSesong) {
        ArrayList<Episode> klonetArrayList = new ArrayList<>();
        for (Episode anEpisode : klonetArrayList) {
            if (anEpisode.getSeason() == oensketSesong) {
                klonetArrayList.add(anEpisode);
            }
        }
        return klonetArrayList;
    }

    /**
     * This method updates the average play time of the episodes in the episode list.
     */
    private void updateAveragePlayTime() {
        int totalSpilletid = 0;
        for (Episode anEpisode : episodeArrayList) {
            totalSpilletid += anEpisode.getPlayTime();
        }
        averagePlayTime = totalSpilletid / episodeArrayList.size();
    }

    public ArrayList<Episode> getEpisodeArrayList() {
        return episodeArrayList;
    }

    public void setEpisodeArrayList(ArrayList<Episode> episodeArrayList) {
        this.episodeArrayList = episodeArrayList;
    }

    public int getAveragePlayTime() {
        return averagePlayTime;
    }

    public void setAveragePlayTime(int averagePlayTime) {
        this.averagePlayTime = averagePlayTime;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<TvSeries> getTvSeriesArrayList() {
        return tvSeriesArrayList;
    }

    public static void setTvSeriesArrayList(ArrayList<TvSeries> tvSeriesArrayList) {
        TvSeries.tvSeriesArrayList = tvSeriesArrayList;
    }

    /**
     * @return This method overrides toString method and returns the values of the field variables.
     */
    @Override
    public String toString() {
        return "TvSeries{" +
                "episodeArrayList=" + episodeArrayList +
                ", averagePlayTime=" + averagePlayTime +
                ", numberOfSeasons=" + numberOfSeasons +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * @param o This method overrides the compareTo method and compares the titles of TV series.
     * @return It returns -1, 0 or +1.
     */
    @Override
    public int compareTo(TvSeries o) {
        return title.toUpperCase().compareTo(((TvSeries)o).getTitle().toUpperCase());
    }
}

