package no.hiof.haakonka.obligOOP.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import no.hiof.haakonka.obligOOP.MainJavaFX;
import no.hiof.haakonka.obligOOP.model.Film;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import static no.hiof.haakonka.obligOOP.MainJavaFX.filmListe;

public class MovieOverviewController {

    protected static Film markedMovie;


    @FXML
    private ChoiceBox choiceBoxSortMovies;

    @FXML
    private ListView<Film> filmliste;

    @FXML
    private TextField textFieldReleaseDate,textFieldPlaytime, textFieldSearch;

    @FXML
    private TextArea textAreaDescription;

    @FXML
    private Label labelMovieTitle;

    @FXML
    private ImageView imageViewMoviePoster;

    @FXML
    public void initialize() {
        //Fyller filmlista som vises med filmer
        filmliste.setItems(MainJavaFX.mainJavaFXApplikasjon.getAlleFilmene());

        //Bytter ut filmlista sin toString med cellFactory
        filmliste.setCellFactory(new javafx.util.Callback<ListView<Film>, ListCell<Film>>() {
            @Override
            public ListCell<Film> call(ListView<Film> list) {
                return new FilmCelle();
            }
        });

        //Velger den første filmen i lista til å vises
        filmliste.getSelectionModel().select(0);
        String url = "https://image.tmdb.org/t/p/w500" + filmliste.getItems().get(0).getUrl();
        Image image = new Image(url);
        fillInMovieDetails(filmliste.getItems().get(0),image);


        //Oppretter nedtrekksliste
        Collections.sort(filmListe);
        choiceBoxSortMovies.getItems().addAll("0-Z", "Z-0","Newest","Oldest");
        choiceBoxSortMovies.getSelectionModel().select("0-Z");

        //Søkefunksjon
        textFieldSearch.setOnKeyTyped(new EventHandler<>() {
            @Override
            public void handle(KeyEvent event) {
                String userSearch = textFieldSearch.getText().toUpperCase();
                for (Film aMovie: filmListe
                     ) {
                    String aMovieString = aMovie.getTitle().toUpperCase();

                    if(aMovieString.contains(userSearch)){
                        filmliste.getSelectionModel().select(aMovie);
                        int focusedMovie = filmliste.getFocusModel().getFocusedIndex();
                        filmliste.scrollTo(focusedMovie);
                        break;
                    }
                }
            }
        });

        //Sorteringsfunksjonalitet
        choiceBoxSortMovies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
        public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                String chosenSortMethod = choiceBoxSortMovies.getValue().toString();
                switch (chosenSortMethod) {
                    case "0-Z":
                        Collections.sort(filmListe);
                        break;
                    case "Z-0":
                        Collections.sort(filmListe);
                        Collections.reverse(filmListe);
                        break;
                    case "Newest":
                        Collections.sort(filmListe, new SortByReleaseDate());
                        break;
                    case "Oldest":
                        Collections.sort(filmListe, new SortByReleaseDate().reversed());
                        break;
                }
            }
        });

            //Metode for å fylle inn detaljene til den filmen man trykker på i lista
            filmliste.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
                @Override
                public void changed(ObservableValue<? extends Film> observable, Film gammelFilm, Film nyFilm) {
                    if (nyFilm != null) {

                        String url = "https://image.tmdb.org/t/p/w500" + nyFilm.getUrl();
                        Image image = new Image(url);
                        fillInMovieDetails(nyFilm,image);
                    }
                }
            });
        }


    public void redigerFilm(ActionEvent actionEvent) throws IOException {

        if(filmliste.getSelectionModel().getSelectedItem() != null) {
            markedMovie = filmliste.getSelectionModel().getSelectedItem();
            MainJavaFX.mainJavaFXApplikasjon.redigerFilm();
        }
    }

    public void addNewMovie(ActionEvent actionEvent)throws IOException {
        MainJavaFX.mainJavaFXApplikasjon.addNewMovie();
    }

    public void btnDeleteMovie(ActionEvent actionEvent) {
        markedMovie = filmliste.getSelectionModel().getSelectedItem();
        MainJavaFX.mainJavaFXApplikasjon.getAlleFilmene().remove(markedMovie);
    }


    public static class FilmCelle extends ListCell<Film> {
        @Override
        public void updateItem(Film aFilm, boolean empty) {
            if(aFilm != null) {
                super.updateItem(aFilm, empty);
                setText(aFilm.getTitle() + " - " + aFilm.getReleaseDate());
            }
        }
    }

private void fillInMovieDetails(Film newFilm, Image poster){
        textAreaDescription.setText(newFilm.getDescription());
        labelMovieTitle.setText(newFilm.getTitle());
        textFieldPlaytime.setText(String.valueOf(newFilm.getPlayTime()));
        textFieldReleaseDate.setText(String.valueOf(newFilm.getReleaseDate()));
        imageViewMoviePoster.setImage(poster);
        }
}
class SortByReleaseDate implements Comparator<Film>{

    @Override
    public int compare(Film o1, Film o2) {
        return o2.getReleaseDate().compareTo(o1.getReleaseDate());
    }
}