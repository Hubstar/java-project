package no.hiof.haakonka.obligOOP.model;

import java.time.LocalDate;


public class Episode extends Production implements Comparable<Episode> {
    private int episodeNumber;
    private int season;


    public Episode(int episodenummer, int sesong, String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
        this.episodeNumber = episodenummer;
        this.season = sesong;
    }

    public Episode(int episodenummer, int sesong, String tittel, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, utgivelsesdato, beskrivelse);
        this.episodeNumber = episodenummer;
        this.season = sesong;
    }


    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        if (playTime != 0) {
            return "Episode number: " + episodeNumber + " Season: " + season + " Title: " + title + " Play time: " + playTime;
        }
        else {
            return "Episode number: " + episodeNumber + " Season: " + season + " Title: " + title;
        }
    }

    @Override
    public int compareTo(Episode o) {
        if ((season > o.getSeason()) || ((season == o.getSeason()) && (episodeNumber > o.getEpisodeNumber()))){
        return 1;
    }else if((season == o.getSeason() && (episodeNumber == o.getEpisodeNumber()))){
            return  0;
        }else
            return -1;
    }
}
