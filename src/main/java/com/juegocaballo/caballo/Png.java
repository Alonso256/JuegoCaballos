package com.juegocaballo.caballo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;

public class Png extends GridPane {
    ArrayList<ImageView> baraja=new ArrayList<>();

    Image png1=new Image("https://es.liveworksheets.com/jb1282215hi");
    Image png2=new Image("https://es.scribd.com/document/373673885/Baraja-Espanola-Para-Imprimir");

    ImageView cartal=new ImageView(png1);
    ImageView carta2=new ImageView(png2);

    public Png(){
        baraja.add(cartal);
        baraja.add(carta2);
        Collections.shuffle(baraja);
    }
    public ArrayList<ImageView>mazo(){
        return baraja;
    }
}
