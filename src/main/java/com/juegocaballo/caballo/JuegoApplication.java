package com.juegocaballo.caballo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JuegoApplication {
    private int id;

    protected void start(int id) throws IOException {
        this.id = id;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 634);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        JuegoController.inicializarBaraja();

    }


}