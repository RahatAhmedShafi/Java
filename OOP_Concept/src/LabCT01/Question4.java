package LabCT01;

//public class Question4 {
//}
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }
}

 class Main3 {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Karim"));
        students.add(new Student("Rahat"));
        students.add(new Student("Akash"));
        students.add(new Student("Anika"));

        Collections.sort(students);

        System.out.println("Sorted Students:");

        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}