package com.juegocaballo.caballo;


import com.juegocaballo.caballo.baraja.Carta;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import java.util.ArrayList;
import java.util.List;

public class JuegoApplication {
    static GridPane board = new GridPane();
    private static int fila = 5;
    private static Stage stage;

    protected void start() throws IOException {
        JuegoController.inicializarBaraja();

        HBox hBox = new HBox();

        GridPane Baraja = new GridPane();


        Baraja.setAlignment(Pos.CENTER_RIGHT);

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 7; j++)
                board.add(new Rectangle(50, 50, Color.BEIGE), i, j);

        board.setGridLinesVisible(true);

        hBox.getChildren().addAll(board, Baraja);


        Scene display = new Scene(hBox);
        stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(display);
        stage.show();

        actualizarGrid(board, Baraja);
    }

    protected static void actualizarGrid(GridPane board, GridPane baraja) throws FileNotFoundException {

        FileInputStream imageStream;

        Image image;


        for (int f = 0; f < 6; f++) {
            image = JuegoController.imprimirSeisCartas();
            board.add(new ImageView(image), 0, f);
        }


        List<Carta> caballos = new ArrayList<>();
        caballos.add(JuegoController.getBaraja(10));
        caballos.add(JuegoController.getBaraja(22));
        caballos.add(JuegoController.getBaraja(34));
        caballos.add(JuegoController.getBaraja(46));

        for (int i = 0; i < 4; i++) {
            Carta c = caballos.get(i);
            c.setX(i + 1);
            c.setY(6);
            JuegoController.setCaballos(c);
            image = JuegoController.imprimirCaballos(c.getId());
            board.add(new ImageView(image), i + 1, 6);
        }

        Button b = new Button("Sacar carta");
        baraja.add(b, 0, 1);

        b.setOnAction(event -> {
            try {
                empezarJuego(baraja);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private static void empezarJuego(GridPane baraja) throws IOException {
        try {
            Carta c = JuegoController.sacarCarta();
            baraja.add(new ImageView(new Image(new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\" + c.getId() + ".png"))), 0, 0);

            comprobarCarta(c);
        } catch (java.lang.NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fin del juego");
            alert.setHeaderText("No hay cartas");
            alert.setContentText("No hay cartas para sacar");
            alert.showAndWait();
        }
    }

    private static void comprobarCarta(Carta c) throws FileNotFoundException {
        try {
            if (c.getId() <= 11) {

                Carta caballo = JuegoController.getCaballos(10);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());
                if (caballo.getY() == 0) {
                    throw new Exception("Oros ha ganado");
                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCaballos(10)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);

            } else if (c.getId() <= 23) {
                Carta caballo = JuegoController.getCaballos(22);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());
                if (caballo.getY() == 0) {
                    throw new Exception("Espadas ha ganado");
                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCaballos(22)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);
            } else if (c.getId() <= 35) {
                Carta caballo = JuegoController.getCaballos(34);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());
                if (caballo.getY() == 0) {
                    throw new Exception("Bastos ha ganado");
                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCaballos(34)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);
            } else if (c.getId() <= 47) {
                Carta caballo = JuegoController.getCaballos(46);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());
                if (caballo.getY() == 0) {
                    throw new Exception("Copas ha ganado");
                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCaballos(46)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);
            }
            //true se quita la carta
            if (comprobarFila()) {
                int id = JuegoController.getUnaCartaSeis().getId();
                board.add(new ImageView(JuegoController.imprimirCarta(id)), 0, fila + 1);
                if (id <= 11) {
                    Carta caballo = JuegoController.getCaballos(10);

                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCaballos(10)), caballo.getX(), caballo.getY());

                    JuegoController.setCaballos(caballo);
                } else if (id <= 23) {
                    Carta caballo = JuegoController.getCaballos(22);
                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCaballos(22)), caballo.getX(), caballo.getY());
                    JuegoController.setCaballos(caballo);
                } else if (id <= 35) {
                    Carta caballo = JuegoController.getCaballos(34);
                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCaballos(34)), caballo.getX(), caballo.getY());
                    JuegoController.setCaballos(caballo);
                } else if (id <= 47) {
                    Carta caballo = JuegoController.getCaballos(46);
                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCaballos(46)), caballo.getX(), caballo.getY());
                    JuegoController.setCaballos(caballo);
                }

            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fin del juego");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();

            HelloController.cerrarVentana(new HelloApplication().getStage());
            stage.close();

        }
    }

    /**
     * Comprueba si en la fila estan todos los caballos para desvelar la carta
     *
     * @return
     */
    private static boolean comprobarFila() {
        List<Carta> cartas = JuegoController.getCaballos();
        int contador = 0;
        for (int i = 0; i < cartas.size(); i++) {
            Carta caballo = cartas.get(i);
            if (caballo.getY() <= fila) {
                contador++;
            }
        }
        if (contador == 4) {
            fila--;
            return true;
        }
        return false;
    }

   /* private static List getNode(Integer n) {

        Carta c = JuegoController.getCaballos(n);
        int row = c.getX();
        int col = c.getY();


        List<Node> matchingNodes = new ArrayList<>();


        for (Node node : board.getChildren()) {
            if (GridPane.getColumnIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                matchingNodes.add(node);
            }
        }


        return matchingNodes;

    }*/

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