package no.hiof.haakonka.obligOOP.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import no.hiof.haakonka.obligOOP.MainJavaFX;
import java.io.IOException;
import java.time.LocalDate;

public class EditMovieController {

    @FXML
    private TextField editMoviePlayTime,editMovieReleaseDate,editMovieTitle;

    @FXML
    private TextArea editMovieDescription;

    @FXML
    public void initialize() {
        editMovieDescription.setText(MovieOverviewController.markedMovie.getDescription());
        editMoviePlayTime.setText(String.valueOf(MovieOverviewController.markedMovie.getPlayTime()));
        editMovieReleaseDate.setText(String.valueOf(MovieOverviewController.markedMovie.getReleaseDate()));
        editMovieTitle.setText(MovieOverviewController.markedMovie.getTitle());
        }

    public void btnEditMovieExit(ActionEvent actionEvent)throws IOException{

        MainJavaFX.mainJavaFXApplikasjon.viewMovieList();
    }

    public void btnEditMovieOK(ActionEvent actionEvent) {
        MovieOverviewController.markedMovie.setTitle(editMovieTitle.getText());
        MovieOverviewController.markedMovie.setReleaseDate(LocalDate.parse(editMovieReleaseDate.getText()));
        MovieOverviewController.markedMovie.setPlayTime(Integer.parseInt(editMoviePlayTime.getText()));
        MovieOverviewController.markedMovie.setDescription(editMovieDescription.getText());
    }
}