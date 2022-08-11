package com.juegocaballo.caballo;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onOrosClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start(1);
    }

    @FXML
    protected void onBastosClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start(2);
    }

    @FXML
    protected void onEspadasClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start(3);
    }

    @FXML
    protected void onCopasClick() throws IOException {
        esconderVentana(new HelloApplication().getStage());
        new JuegoApplication().start(4);
    }

    protected void esconderVentana(Stage w) {
        w.hide();
    }

    protected static void cerrarVentana(Stage w) {
        w.close();
    }

}