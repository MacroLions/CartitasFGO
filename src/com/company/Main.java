package com.company;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        Servant s1=new Servant();
        Servant s2=new Servant();
        Servant s3=new Servant();
        ArrayList<Servant> Servants = new ArrayList<Servant>();



        Servants.add(s1);
        Servants.add(s2);
        Servants.add(s3);

        int i=1;
        for (Servant iser:Servants) {
            System.out.println("Ingrese las cartas del servant "+i+" separadas por coma: ");
            ArrayList<String> setCartas2 = new ArrayList<String>(Arrays.asList(input.nextLine().split(",")));
            iser.setCartas(setCartas2);
            i++;
        }

        int n;

        System.out.println("Ingrese el número de decks que generará: ");
        n=input.nextInt();

        Deck cartasEquipo;

        int quick=0,arts=0,buster=0,x=0;

        ArrayList<ArrayList<String>> ComboporTurno = new ArrayList<ArrayList<String>>();
        ArrayList<String> Turno1= new ArrayList<String>(),Turno2= new ArrayList<String>(),Turno3= new ArrayList<String>();
        ComboporTurno.add(Turno1);
        ComboporTurno.add(Turno2);
        ComboporTurno.add(Turno3);

        for (int j = 0; j < n ; j++) {
            cartasEquipo = new Deck(s1.getCartas(),s2.getCartas(),s3.getCartas());
            System.out.println("Deck "+(j+1)+":");
            System.out.println(cartasEquipo.getTurnos());
            System.out.println();
            System.out.println(cartasEquipo.getCombos());

            for (String c:cartasEquipo.combos) {
                if (c.equals("Q")){
                    quick++;
                }else if(c.equals("A")){
                    arts++;
                }else if(c.equals("B")) {
                    buster++;
                }else{
                    x++;
                }
            }

            //Extra

            for (int k = 0; k < 3 ; k++) {
                if(cartasEquipo.combos.get(k).equals("Q")){
                    ComboporTurno.get(k).add("Q");
                }else if(cartasEquipo.combos.get(k).equals("A")){
                    ComboporTurno.get(k).add("A");
                }else if(cartasEquipo.combos.get(k).equals("B")){
                    ComboporTurno.get(k).add("B");
                }else{
                    ComboporTurno.get(k).add("X");
                }
            }

            System.out.println();
        }
        int quickT=0,artsT=0,busterT=0,xT=0;

        System.out.println("Probabilidades de combo por turno:");
        for (int j = 0; j < 3 ; j++) {

            quickT=0;artsT=0;busterT=0;xT=0;

            for (int k = 0; k < ComboporTurno.get(j).size(); k++) {
                if (ComboporTurno.get(j).get(k).equals("Q")){
                    quickT++;
                }else if(ComboporTurno.get(j).get(k).equals("A")){
                    artsT++;
                }else if(ComboporTurno.get(j).get(k).equals("B")) {
                    busterT++;
                }else{
                    xT++;
                }
            }
            System.out.println("Turno"+(j+1)+
                    ": Quick "+String.format("%.2f",(quickT/((3.0*n)/3))*100)+
                    "% Arts "+String.format("%.2f",(artsT/((3.0*n)/3))*100)+
                    "% Buster "+String.format("%.2f",(busterT/((3.0*n)/3))*100)+
                    "% No Combo "+String.format("%.2f",(xT/((3.0*n)/3))*100)+"%");
        }

        System.out.println();
        System.out.println("Probabilidades de combo en toda la partida:");
        System.out.println("Quick: "+String.format("%.2f",(quick/(3.0*n))*100)+"%");
        System.out.println("Arts: "+String.format("%.2f",(arts/(3.0*n))*100)+"%");
        System.out.println("Buster: "+String.format("%.2f",(buster/(3.0*n))*100)+"%");
        System.out.println("Sin combo: "+String.format("%.2f",(x/(3.0*n))*100)+"%");
        input.nextLine();




    }
}
