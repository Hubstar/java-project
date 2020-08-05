package no.hiof.haakonka.obligOOP.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Film extends Production implements Comparable<Film> {
    /**
     * This class is a subclass of the Production class and implements the Comparable contract.
     * It has three different constructors in case some information is lacking.
     * @param tittel Is the title.
     * @param beskrivelse Is the description.
     * @param spilletid Is the play time.
     * @param utgivelsesdato Is the release date.
     * @param url is the URL of the posters.
     */
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato,  String url) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse, url);
    }

   public Film(String tittel, int spilletid, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, spilletid, utgivelsesdato, beskrivelse);
    }

    public Film(String tittel, LocalDate utgivelsesdato, String beskrivelse) {
        super(tittel, utgivelsesdato, beskrivelse);
    }

    /**
     * @return This method overrides the toString method and returns the values of the field variables.
     */
    @Override
    public String toString() {
        return "Filmtittel: " + title + " Spilletid: " + playTime + " Utgivelsesdato: " + releaseDate + " Beskrivelse: " +
                description + "URL:" + url;
    }

    /**
     * @param o This method overrides the compareTo method and compares the titles of film objects.
     * @return I returns -1, 0 or +1.
     */
    @Override
    public int compareTo(Film o) {
        return getTitle().toUpperCase().compareTo(o.getTitle().toUpperCase());
    }
}
