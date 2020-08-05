package no.hiof.haakonka.obligOOP.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import no.hiof.haakonka.obligOOP.MainJavaFX;
import no.hiof.haakonka.obligOOP.model.Film;

import java.io.IOException;
import java.time.LocalDate;

public class NewMovieController {

    @FXML
    private TextArea textAreaNewMovieDescription;

    @FXML
    private TextField textFieldNewMoviePlaytime,textFieldNewMovieTitle,textFieldNewMovieReleaseDate;


    private static Film newMovie;

    public void btnNewMovieCancel(ActionEvent actionEvent)throws IOException {
        MainJavaFX.mainJavaFXApplikasjon.viewMovieList();
    }

    public void btnNewMovieAdd(ActionEvent actionEvent) throws IOException {
        if (textAreaNewMovieDescription != null && textFieldNewMoviePlaytime != null && textFieldNewMovieReleaseDate != null && textFieldNewMovieTitle != null) {
            newMovie = new Film(textFieldNewMovieTitle.getText(), Integer.parseInt(textFieldNewMoviePlaytime.getText()),
                    LocalDate.parse(textFieldNewMovieReleaseDate.getText()), textAreaNewMovieDescription.getText());
            MainJavaFX.mainJavaFXApplikasjon.addNewMovieToList(newMovie);
            MainJavaFX.mainJavaFXApplikasjon.viewMovieList();
        }
    }
}
