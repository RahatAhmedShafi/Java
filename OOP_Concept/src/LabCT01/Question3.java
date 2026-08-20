package LabCT01;

//public class Question3 {
//}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class City {
    String name;
    int population;

    City(String name, int population) {
        this.name = name;
        this.population = population;
    }
}

class Main2 {
    public static void main(String[] args) {

        ArrayList<City> cities = new ArrayList<>();

        cities.add(new City("Dhaka", 22000000));
        cities.add(new City("Chittagong", 8000000));
        cities.add(new City("Rajshahi", 900000));
        cities.add(new City("Khulna", 1500000));

        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return c1.name.compareTo(c2.name);
            }
        });

        System.out.println("Cities in Alphabetical Order:");

        for (City c : cities) {
            System.out.println(c.name + " - " + c.population);
        }
    }
}
