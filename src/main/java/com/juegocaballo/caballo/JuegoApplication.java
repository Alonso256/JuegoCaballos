package com.juegocaballo.caballo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JuegoApplication {
    private int id;

    protected void start(int id) throws IOException {
        this.id = id;
        JuegoController.inicializarBaraja();

        HBox hBox = new HBox();
        GridPane board = new GridPane();

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 6; j++)
                board.add(new Rectangle(50, 50, Color.BEIGE), i, j);

        board.setGridLinesVisible(true);

        hBox.getChildren().add(board);

        Scene display = new Scene(hBox);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(display);
        stage.show();


     /*   Png img = new Png();
        Image image = new Image("File:com/juegocaballo/caballo/png1.png");
        ImageView imageView = new ImageView();
        imageView.setFitWidth(130);
        imageView.setFitHeight(130);
        imageView.setImage(image);
        board.add(imageView, 2, 2);*/


        actualizarGrid(board);
    }

    protected static void actualizarGrid(GridPane board) throws FileNotFoundException {

        FileInputStream imageStream;

        Image image;


        for (int i = 0; i < 1; i++) {
            for (int f = 0; f < 6; f++) {
                image = JuegoController.imprimirSeisCartas(f);
                board.add(new ImageView(image), i, f);

            }
        }

    }

    private Stage actualizar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 634);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        return stage;
    }


}