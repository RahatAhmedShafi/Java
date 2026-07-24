package LabCT01;

//public class Question2 {
//
//}

import java.util.ArrayList;

class Employee{
    String name;
    String dpt;
    int salary;
    Employee(String name, String dpt, int salary){
        this.name=name;
        this.dpt=dpt;
        this.salary=salary;
    }
}
class Main{
    static void main(String[] args) {
        ArrayList<Employee> employees =new ArrayList<Employee>();
        employees.add(new Employee("Rahat","It",200));
        employees.add(new Employee("Rahim","It",300));
        employees.add(new Employee("Karim","It",600));

        for (Employee em : employees){
            if (em.salary>300){
                System.out.println(em.name + " : " + em.salary);
            }
        }
        int count=0;
        for (Employee em:employees){
            if (em.name.startsWith("R")){
                count++;
            }
        }
        System.out.println("Names starting with R = " + count);
    }


}

