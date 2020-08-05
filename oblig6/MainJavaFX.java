//Har samarbeidet med Kristian Midtgård


package no.hiof.haakonka.obligOOP;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.hiof.haakonka.obligOOP.model.Film;
import java.io.IOException;

import static no.hiof.haakonka.obligOOP.model.DataHandler.makeMovieList;
import static no.hiof.haakonka.obligOOP.model.DataHandler.readFile;

public class MainJavaFX extends Application {

    public static ObservableList<Film> filmListe = FXCollections.observableArrayList();
    private Stage primaryStage;
    public static MainJavaFX mainJavaFXApplikasjon;


    public MainJavaFX() {
        mainJavaFXApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;
        readFile();
        viewMovieList();
    }

    public void viewMovieList() throws IOException {

        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/MovieOverview.fxml"));
        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout,   1000, 500);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Movie list");
        primaryStage.show();
    }

    public void redigerFilm() throws IOException{

        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/EditMovie.fxml"));
        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout, 800, 500);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Edit movie");
    }

    public void addNewMovie() throws IOException{

        FXMLLoader fxmlInnlaster = new FXMLLoader();
        fxmlInnlaster.setLocation(getClass().getResource("view/NewMovie.fxml"));
        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout, 800, 500);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Add new Movie");
    }

    public ObservableList<Film> getAlleFilmene() {
        return filmListe;
    }
   
    public static void addNewMovieToList(Film newMovie) {
        filmListe.add(newMovie);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        makeMovieList();
        super.stop();
    }
}