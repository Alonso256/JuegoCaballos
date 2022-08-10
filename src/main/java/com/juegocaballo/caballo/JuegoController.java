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

    private static List<Carta> Caballos = new ArrayList<>();


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

    protected static Carta getBaraja(int i) {
        return baraja.get(i);
    }

    protected static void setCaballos(Carta c) {
        Caballos.removeIf(carta -> carta.getPalo() == c.getPalo());
        Caballos.add(c);

    }

    protected static Carta getCaballos(int n) {
        for (Carta c : Caballos) {
            if (c.getId() == n) {
                return c;
            }

        }
        return null;
    }

    protected static List<Carta> getCaballos() {
        return Caballos;
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

        //Quitar cabballos
        barajeada.remove(10);
        barajeada.remove(22);
        barajeada.remove(34);
        barajeada.remove(46);

        sacarSeisCartas();

    }

    /**
     * Metodo que saca seis cartas y desoues las elimina de la baraja barajeada
     */
    protected static void sacarSeisCartas() {

        for (Carta c : barajeada.values()) {
            if (SeisCartas.size() < 6) {
                SeisCartas.put(SeisCartas.size(), c);

            } else {
                break;
            }
        }

        Iterator<Map.Entry<Integer, Carta>> iterator = barajeada.entrySet().iterator();
        for (Carta c : SeisCartas.values()) {
            while (iterator.hasNext()) {
                Map.Entry<Integer, Carta> entry = iterator.next();
                if (entry.getValue().equals(c)) {
                    iterator.remove();
                }
            }
        }


    }

    /**
     * Metodo que devuelve una carta de las seis cartas sacadas
     *
     * @return HashMap barajeada
     */
    protected static Carta getUnaCartaSeis() {
        Carta c = null;
        int k = 0;
        for (Integer Key : SeisCartas.keySet()) {
            c = SeisCartas.get(Key);
            k = Key;
            break;
        }
        SeisCartas.remove(k);
        return c;
    }

    protected static Image imprimirSeisCartas() throws FileNotFoundException {
        FileInputStream imageStream;

        Image image;
        /* Carta c = SeisCartas.get(i);*/
        imageStream = new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\48.png");
        image = new Image(imageStream);

        return image;
    }

    protected static Image imprimirCaballos(int i) throws FileNotFoundException {
        FileInputStream imageStream;

        Image image;
        imageStream = new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\" + i + ".png");
        image = new Image(imageStream);


        return image;
    }

    protected static Image imprimirBlanco() throws FileNotFoundException {
        FileInputStream imageStream;

        Image image;
        imageStream = new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\49.png");
        image = new Image(imageStream);


        return image;
    }

    protected static Image imprimirCarta(int i) throws FileNotFoundException {
        FileInputStream imageStream;

        Image image;
        imageStream = new FileInputStream("src\\main\\java\\com\\juegocaballo\\caballo\\images\\" + i + ".png");
        image = new Image(imageStream);


        return image;
    }

    protected static Carta sacarCarta() {
        Carta c = null;
        int k = 0;
        for (Integer Key : barajeada.keySet()) {
            c = barajeada.get(Key);
            k = Key;
            break;
        }
        barajeada.remove(k);
        return c;
    }

}

