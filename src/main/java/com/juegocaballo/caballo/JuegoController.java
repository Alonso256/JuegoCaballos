package com.juegocaballo.caballo;

import com.juegocaballo.caballo.baraja.Carta;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class JuegoController {
    private static HashMap<Integer, Carta> baraja = new HashMap<Integer, Carta>();
    private static HashMap<Integer, Carta> barajeada = new LinkedHashMap<Integer, Carta>();//Tiene que ser Linked para que no me las ordene por clave

    private static HashMap<Integer, Carta> SeisCartas = new HashMap<Integer, Carta>();

    /**
     * Metodo que crea la baraja de cartas
     */
    protected static void inicializarBaraja() {
        Carta carta;

        for (int i = 0; i < 48; i++) {
            carta = new Carta(i, (i % 12) + 1, (i <= 11) ? "Oros" : (i <= 23) ? "Espadas" : (i <= 35) ? "Bastos" : (i <= 47) ? "Copas" : " " + (i % 4));
            baraja.put(i, carta);
        }
        //visualizar baraja
        for (int i = 0; i < 48; i++) {
            System.out.println(baraja.get(i).toString());
        }
        barajar();
    }


    /**
     * Metodo que mezcla las cartas de manera aleatoria y las añade a el HashMap barajeada
     */
    protected static void barajar() {
        for (int i = 0; i < 48; i++) {
            int numeroAleatorio = (int) (Math.random() * 48 + 0);
            if (barajeada.containsKey(numeroAleatorio)) {
                i--;
                continue;
            } else {
                Carta carta = baraja.get(numeroAleatorio);
                barajeada.put(numeroAleatorio, carta);
            }
        }

        //visualizar baraja barajeada
       /* for (Map.Entry<Integer, Carta> entry : barajeada.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        sacarSeisCartas();

    }

    protected static void sacarSeisCartas() {
        for (Carta c : barajeada.values()) {
            if (SeisCartas.size() < 6) {
                SeisCartas.put(SeisCartas.size(), c);
            } else {
                break;
            }
        }
    }

    protected static Image imprimirSeisCartas(int i) throws FileNotFoundException {
        FileInputStream imageStream;

        Image image;
        Carta c = SeisCartas.get(i);
        imageStream = new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\"+c.getId()+".png");
        image = new Image(imageStream);

        return image;
    }

   /* protected static void actualizarGrid() {
        Label text = new Label("Memoriza");
        HBox hb = new HBox(text);
        BorderPane p = new BorderPane();
        p.setTop(hb);
        GridPane gp = new GridPane();

        Png img = new Png();

        for (int i = 0; i < 4; i++) {
            for (int f = 0; f < 2; f++) {
                gp.add(img.mazo().get(i), i, f);
            }
        }
        p.setCenter(gp);
    }*/
}

