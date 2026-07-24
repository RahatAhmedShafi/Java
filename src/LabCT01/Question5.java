package LabCT01;

//public class Question5 {
//}

import java.util.HashMap;

class Course {

    int id;
    String name;

    Course(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

 class Main4 {

    public static void main(String[] args) {

        HashMap<Integer, Course> map = new HashMap<>();

        map.put(101, new Course(101, "Java"));
        map.put(102, new Course(102, "Database"));
        map.put(103, new Course(103, "Networking"));

        int searchID = 102;

        if (map.containsKey(searchID)) {
            Course c = map.get(searchID);

            System.out.println("Course Found");
            System.out.println("ID: " + c.id);
            System.out.println("Name: " + c.name);
        } else {
            System.out.println("Course Not Found");
        }
    }
}
