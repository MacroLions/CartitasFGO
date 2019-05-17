package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deck {
    ArrayList<String> cartasS1 = new ArrayList<String>();
    ArrayList<String> cartasS2 = new ArrayList<String>();
    ArrayList<String> cartasS3 = new ArrayList<String>();

    ArrayList<ArrayList<String>> cartasServants = new ArrayList<ArrayList<String>>();

    ArrayList<String> turno1 = new ArrayList<String>();
    ArrayList<String> turno2 = new ArrayList<String>();
    ArrayList<String> turno3 = new ArrayList<String>();

    ArrayList<ArrayList<String>> turnos = new ArrayList<ArrayList<String>>();

    ArrayList<String> combos = new ArrayList<String>();

    public Deck(){

    }

    public Deck(ArrayList<String> cartasS1, ArrayList<String> cartasS2, ArrayList<String> cartasS3) {
        this.cartasS1 = (ArrayList<String>) cartasS1.clone();
        this.cartasS2 = (ArrayList<String>) cartasS2.clone();
        this.cartasS3 = (ArrayList<String>) cartasS3.clone();
        setCartasServants();
        setTurnos();
        setCombos();
    }

    public  void setCartasServants(){
        cartasServants.add(cartasS1);
        cartasServants.add(cartasS2);
        cartasServants.add(cartasS3);
    }

    public void setTurnos(){
        turnos.add(turno1);
        turnos.add(turno2);
        turnos.add(turno3);
        //System.out.println(turnos);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {

                int n = (int) (Math.random()*cartasServants.size());
                if (n==cartasServants.size()){
                    n = (int) (Math.random()*cartasServants.size());
                }
                //System.out.println(n);

                int m = (int) (Math.random()*cartasServants.get(n).size());
                if (m==cartasServants.get(n).size()){
                    m = (int) (Math.random()*cartasServants.get(n).size());
                }

                while (m==0 && cartasServants.get(n).size()==0){
                    cartasServants.remove(n);
                    n = (int) (Math.random()*cartasServants.size());
                    if (n==cartasServants.size()){
                        n = (int) (Math.random()*cartasServants.size());
                    }

                    m = (int) (Math.random()*cartasServants.get(n).size());
                    if (m==cartasServants.get(n).size()){
                        m = (int) (Math.random()*cartasServants.get(n).size());
                    }
                }

                turnos.get(i).add(cartasServants.get(n).get(m));
                cartasServants.get(n).remove(m);
                //System.out.println(cartasServants.get(n));
            }
        }
    }


    public void setCombos(){
        int q,a,b;

        for (ArrayList<String>t:turnos) {
            q=0;a=0;b=0;

            for (int i = 0; i < t.size(); i++) {
                if(t.get(i).equals("q")||t.get(i).equals("Q")){
                    q++;
                }else if(t.get(i).equals("a")||t.get(i).equals("A")){
                    a++;
                }else if(t.get(i).equals("b")||t.get(i).equals("B")){
                    b++;
                }

            }

            if(q>=3){
                combos.add("Q");
            }else if(a>=3){
                combos.add("A");
            }else if(b>=3){
                combos.add("B");
            }else{
                combos.add("X");
            }
        }
    }


    public void Reset(){

    }

    public void setCartasS1(ArrayList<String> cartasS1) {
        this.cartasS1 = cartasS1;
    }

    public void setCartasS2(ArrayList<String> cartasS2) {
        this.cartasS2 = cartasS2;
    }

    public void setCartasS3(ArrayList<String> cartasS3) {
        this.cartasS3 = cartasS3;
    }

    public ArrayList<String> getCombos() {
        return combos;
    }

    public ArrayList<ArrayList<String>> getTurnos() {
        return turnos;
    }

    public ArrayList<String> getCartasS1() {
        return cartasS1;
    }

    public ArrayList<String> getCartasS2() {
        return cartasS2;
    }

    public ArrayList<String> getCartasS3() {
        return cartasS3;
    }

    public ArrayList<ArrayList<String>> getCartasServants() {
        return cartasServants;
    }
}
