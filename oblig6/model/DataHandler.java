package no.hiof.haakonka.obligOOP.model;

import javafx.scene.control.Alert;
import no.hiof.haakonka.obligOOP.MainJavaFX;
import java.io.*;
import java.time.LocalDate;

import static no.hiof.haakonka.obligOOP.MainJavaFX.addNewMovieToList;

public class DataHandler {
    public static void readFile() {

        File kilde = new File("filmer_1000.csv");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(kilde))) {
            String textLine;

            while ((textLine = bufferedReader.readLine()) != null) {
                String[] textParts = textLine.split(";");
                Film k = new Film(textParts[0],textParts[1],Integer.parseInt(textParts[2]),LocalDate.parse(textParts[3]),textParts[4]);
                addNewMovieToList(k);
            }

        } catch (FileNotFoundException e) {
                Alert minAlert = new Alert(Alert.AlertType.ERROR);
                minAlert.setTitle("Error");
                minAlert.setHeaderText(null);
                minAlert.setContentText(""+e);
                minAlert.showAndWait();
                System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void makeMovieList(){

        File kilde = new File("filmer_1000.csv");

        try (BufferedWriter bufretSkriver = new BufferedWriter(new java.io.FileWriter(kilde))) {

            for(Film enFilm: MainJavaFX.filmListe) {

                bufretSkriver.write( enFilm.getTitle() + ";" + enFilm.getDescription() + ";" + enFilm.getPlayTime() + ";" +
                        enFilm.getReleaseDate() + ";" + enFilm.getUrl());
                bufretSkriver.newLine();
            }
        } catch (FileNotFoundException e) {

            Alert minAlert = new Alert(Alert.AlertType.ERROR);
            minAlert.setTitle("Error");
            minAlert.setHeaderText(null);
            minAlert.setContentText(""+e);
            minAlert.showAndWait();
            System.out.println(e);

        } catch (IOException e) {

            System.out.println(e);
        }
    }
}