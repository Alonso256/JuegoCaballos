package com.juegocaballo.caballo;

import com.juegocaballo.caballo.baraja.Carta;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;

public class JuegoController {
    private static HashMap<Integer, Carta> baraja = new HashMap<Integer, Carta>();
    private static HashMap<Integer, Carta> barajeada = new LinkedHashMap<Integer, Carta>();//Tiene que ser Linked para que no me las ordene por clave


    /**
     * Metodo que crea la baraja de cartas
     */
    protected static void inicializarBaraja() {
        Carta carta;

        for (int i = 0; i < 48; i++) {
            carta = new Carta(i, (i % 12) + 1, (i <= 11) ? "Oros" : (i <= 23) ? "Espadas" : (i <= 35) ? "Bastos" : (i <= 47) ? "Copas" : " " + (i % 4));
            baraja.put(i, carta);
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
      /*  // Get all the entries in the map into a list
        List<Map.Entry<Integer, Carta>> entries = new ArrayList<>(baraja.entrySet());

        // Shuffle the list
        Collections.shuffle(entries);

        Map<Integer, Carta> barajeada = new LinkedHashMap<>();
        for (Map.Entry<Integer,Carta> entry : entries) {
            barajeada.put(entry.getKey(), entry.getValue());
        }
*/
        //visualizar baraja barajeada
        for (Map.Entry<Integer, Carta> entry : barajeada.entrySet()) {
             System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
