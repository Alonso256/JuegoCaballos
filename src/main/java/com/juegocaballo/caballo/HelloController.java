package com.juegocaballo.caballo;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onOrosClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start();
    }
    @FXML
    protected void onBastosClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start();
    }
    @FXML
    protected void onEspadasClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start();
    }
    @FXML
    protected void onCopasClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start();
    }

    protected void esconderVentana(Stage w){
        w.hide();
    }
    protected static void cerrarVentana(Stage w){
        w.close();
    }

}