package com.juegocaballo.caballo;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onOrosClick() throws IOException {
        cerrarVentana(new HelloApplication().getStage());
        new JuegoApplication().start(1);
    }
    @FXML
    protected void onBastosClick() throws IOException {
        cerrarVentana(new HelloApplication().getStage());
        new JuegoApplication().start(2);
    }
    @FXML
    protected void onEspadasClick() throws IOException {
        cerrarVentana(new HelloApplication().getStage());
        new JuegoApplication().start(3);
    }
    @FXML
    protected void onCopasClick() throws IOException {
        cerrarVentana(new HelloApplication().getStage());
        new JuegoApplication().start(4);
    }

    protected void cerrarVentana(Stage w){
        w.hide();
    }

}