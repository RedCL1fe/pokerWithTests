package org.example;

public class Main {
    public static void main(String[] args) {
        //Привел в пример, как могут быть использованы
        PokerHand pokerHand1 = new PokerHand("2C 3C AC 4C 5C");
        PokerHand pokerHand2 = new PokerHand("KS 2H 5C JD TD");

        int result = pokerHand1.compareTo(pokerHand2);

        if (result == 1) {
            System.out.println("Рука 1 сильнее");
        } else if (result == -1) {
            System.out.println("Рука 2 сильнее");
        } else {
            System.out.println("Руки равны");
        }
    }
}