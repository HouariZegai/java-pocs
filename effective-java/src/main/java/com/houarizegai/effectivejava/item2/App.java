package com.houarizegai.effectivejava.item2;

public class App {

    public static void main(String[] args) {
        Pizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.MUSHROOM)
                .build();
        System.out.println(nyPizza.toppings);

        Pizza calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();
        System.out.println(calzone.toppings);
    }
}
