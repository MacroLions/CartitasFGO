package com.company;


import java.util.ArrayList;

public class Servant {
    ArrayList<String> Cartas = new ArrayList<String>();

    public Servant() {
    }

    public ArrayList<String> getCartas() {
        return Cartas;
    }

    public void setCartas(ArrayList<String> cartas) {
        Cartas = cartas;
    }
}
