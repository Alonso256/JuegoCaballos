package com.juegocaballo.caballo;

import com.juegocaballo.caballo.baraja.Carta;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;

public class JuegoController {
    private static HashMap<Integer, Carta> baraja = new HashMap<Integer, Carta>();
    private static HashMap<Integer, Carta> barajeada = new HashMap<Integer, Carta>();


    protected static void inicializarBaraja() {
        Carta carta;

        for (int i = 0; i < 48; i++) {
            carta = new Carta(i, (i % 12) + 1, (i <= 11) ? "Oros" : (i <= 23) ? "Espadas" : (i <= 35) ? "Bastos" : (i <= 47) ? "Copas" : " " + (i % 4));
            baraja.put(i, carta);
        }
        barajar();
    }



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
        for (int i = 0; i < 48; i++) {
            Carta carta = barajeada.get(i);
            System.out.println(carta.toString());
        }

    }
}
