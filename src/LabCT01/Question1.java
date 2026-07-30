package LabCT01;

import java.util.ArrayList;
import java.util.Collections;

public class Question1 {
    static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

        if(list.contains(30)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        Collections.sort(list);
        System.out.println(list);
    }


}
