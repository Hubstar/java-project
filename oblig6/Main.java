//Oppgave 4b

package no.hiof.haakonka.obligOOP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.hiof.haakonka.obligOOP.model.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static ObservableList<Film> enFilmListe = FXCollections.observableArrayList();

    public static ArrayList<Film> filmArrayList = new ArrayList<>();

    public static void main(String[] args) {
/*
        System.out.println("Sorterte lister:");

        ArrayList<Episode> episodeArrayList = new ArrayList();

        episodeArrayList.add(new Episode(1, 4,"fesgsg", LocalDate.of(2020,01,01), "gsg"));
        episodeArrayList.add(new Episode(9, 7,"fesgsg", LocalDate.of(2020,01,01), "ghosg"));
        episodeArrayList.add(new Episode(7, 7,"fesgsg", LocalDate.of(2020,01,01), "gsg"));

        Collections.sort(episodeArrayList);
        System.out.println(episodeArrayList);

*/
        ArrayList<Film> filmArrayList = new ArrayList<>();

        filmArrayList.add(new Film("gsg",LocalDate.of(2000,01,01),"jogspjgjp"));
        filmArrayList.add(new Film("aaaaaa",LocalDate.of(2000,01,01),"jogspjgjp"));
        filmArrayList.add(new Film("iiiiii",LocalDate.of(2000,01,01),"jogspjgjp"));

        Collections.sort(filmArrayList);
        System.out.println(filmArrayList);

/*
        ArrayList<TVSerie> tvSerieArrayList = new ArrayList<>();

        tvSerieArrayList.add(new TVSerie("geagssg"));
        tvSerieArrayList.add(new TVSerie("oooooooo"));
        tvSerieArrayList.add(new TVSerie("jfajaa"));

        Collections.sort(tvSerieArrayList);
        System.out.println(tvSerieArrayList);
    }
*/

    }



}
