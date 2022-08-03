package com.juegocaballo.caballo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class JuegoApplication {
    private int id;

    protected void start(int id) throws IOException {
        this.id = id;
       //Stage stage ;

        JuegoController.inicializarBaraja();
       // JuegoController.actualizarGrid();

       // stage = actualizar();

        HBox hBox = new HBox();
        GridPane board = new GridPane();

        for(int i = 0; i<5;i++)
            for (int j = 0; j<5 ; j++)
                board.add(new Rectangle(50,50, Color.BEIGE),i,j);

        board.setGridLinesVisible(true);

        hBox.getChildren().add(board);

        Scene display = new Scene(hBox);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(display);
        stage.show();

       /* Scene display = new Scene(board);
        stage.setScene(display);
        stage.show();*/

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