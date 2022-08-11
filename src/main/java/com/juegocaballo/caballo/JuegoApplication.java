package com.juegocaballo.caballo;


import com.juegocaballo.caballo.baraja.Carta;
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
    private static int jugador;

    protected void start(int num) throws IOException {
        jugador = num;
        JuegoController.inicializarBaraja();

        HBox hBox = new HBox();

        GridPane Baraja = new GridPane();


        Baraja.setAlignment(Pos.CENTER_RIGHT);

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 7; j++)
                board.add(new Rectangle(70, 100, Color.BEIGE), i, j);

        board.setGridLinesVisible(true);

        hBox.getChildren().addAll(board, Baraja);


        Scene display = new Scene(hBox);
        stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(display);

        stage.setHeight(840);
        stage.setWidth(500);
        stage.show();

        actualizarGrid(board, Baraja);
    }

    /**
     * Metodo que empieza el juego
     *
     * @param board
     * @param baraja
     * @throws FileNotFoundException
     */
    protected static void actualizarGrid(GridPane board, GridPane baraja) throws FileNotFoundException {

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
            image = JuegoController.imprimirCarta(c.getId());
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

    /**
     * Metodo que añade las imagenes de las cartas
     *
     * @param baraja
     * @throws IOException
     */
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

    /**
     * Comprueba que tipo de carta es y realiza la accion correspondiente
     *
     * @param c
     */
    private static void comprobarCarta(Carta c) {

        try {
            if (c.getId() <= 11) {

                Carta caballo = JuegoController.getCaballos(10);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                if (caballo.getY() == 0) {
                    if(jugador == 1)
                        throw new Exception("Oros ha ganado, HAS GANADO");
                    else
                        throw new Exception("Oros ha ganado, HAS PERDIDO");
                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCarta(10)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);

            } else if (c.getId() <= 23) {
                Carta caballo = JuegoController.getCaballos(22);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                if (caballo.getY() == 0) {
                    if(jugador == 3)
                        throw new Exception("Espadas ha ganado, HAS GANADO");
                    else
                        throw new Exception("Espadas ha ganado, HAS PERDIDO");

                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCarta(22)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);
            } else if (c.getId() <= 35) {
                Carta caballo = JuegoController.getCaballos(34);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                if (caballo.getY() == 0) {
                    if(jugador == 2)
                        throw new Exception("Bastos ha ganado, HAS GANADO");
                    else
                        throw new Exception("Bastos ha ganado, HAS PERDIDO");

                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCarta(34)), caballo.getX(), caballo.getY());

                JuegoController.setCaballos(caballo);
            } else if (c.getId() <= 47) {
                Carta caballo = JuegoController.getCaballos(46);

                board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                if (caballo.getY() == 0) {
                    if(jugador == 4)
                        throw new Exception("Copas ha ganado, HAS GANADO");
                    else
                        throw new Exception("Copas ha ganado, HAS PERDIDO");

                }
                caballo.setY(caballo.getY() - 1);

                board.add(new ImageView(JuegoController.imprimirCarta(46)), caballo.getX(), caballo.getY());

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

                    board.add(new ImageView(JuegoController.imprimirCarta(10)), caballo.getX(), caballo.getY());

                    JuegoController.setCaballos(caballo);
                } else if (id <= 23) {
                    Carta caballo = JuegoController.getCaballos(22);

                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCarta(22)), caballo.getX(), caballo.getY());

                    JuegoController.setCaballos(caballo);
                } else if (id <= 35) {
                    Carta caballo = JuegoController.getCaballos(34);

                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCarta(34)), caballo.getX(), caballo.getY());

                    JuegoController.setCaballos(caballo);
                } else if (id <= 47) {
                    Carta caballo = JuegoController.getCaballos(46);

                    board.add(new ImageView(JuegoController.imprimirBlanco()), caballo.getX(), caballo.getY());

                    caballo.setY(caballo.getY() + 1);

                    board.add(new ImageView(JuegoController.imprimirCarta(46)), caballo.getX(), caballo.getY());

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
     * Comprueba si en la fila están todos los caballos para desvelar la carta
     *
     * @return true si están todos los caballos en la misma fila
     */
    private static boolean comprobarFila() {
        List<Carta> cartas = JuegoController.getCaballos();
        int contador = 0;
        for (Carta caballo : cartas) {
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

}