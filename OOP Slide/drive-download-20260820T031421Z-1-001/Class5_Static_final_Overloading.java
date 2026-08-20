class Student{
    String name;
    static int trimester;
    double cgpa;
    void displayInfo(float b, int a){
        System.out.println("First function called");
        System.out.println("Name: " + this.name);
        System.out.println("Cgpa: " + cgpa);
    }
    void displayInfo(){
        System.out.println("Second function called");
        System.out.println("Name: " + this.name);
        System.out.println("Cgpa: " + cgpa);
    }
    void displayInfo(int b, float a){
        System.out.println("Second function called");
        System.out.println("Name: " + this.name);
        System.out.println("Cgpa: " + cgpa);
    }
        void function(Student other){
        if(this.cgpa < other.cgpa) System.out.println("You are better");
        else System.out.println("I am better");
    }

    static void function(){
        System.out.println(trimester);
    }
    Student(int a){}
    Student(final String name, int trimester, final double cgpa){
//        name = "Harry";
        this.name = name;
        this.trimester = trimester;
        this.cgpa = cgpa;
        this.cgpa = cgpa + 20;
    }
    Student(String name){
        this.name = name;
    }
    Student(Student other){
        this.cgpa = other.cgpa;
        this.name = other.name;
        this.trimester = other.trimester;
    }

}


class Main {
    public static void main( String args[] )
    {
        Student s1 = new Student("zun");
        Student s2 = new Student("Harry");
        Student s3 = new Student("potter");
        s1.trimester = 20;
        s2.trimester = 30;
        Student.trimester = 100;
        System.out.println(s3.trimester);
        System.out.println(Student.trimester);
        Student.function();















        final int a;
//        Student s = new Student(a);
//        a = -2;
//        System.out.println(a);













//        Student s2 = new Student();
//        Student s = new Student("Zun", 2, 3.2);
//        s.function(s2);
////        Student good_Student = new Student(s);
//        Student good_student = s;
    }
}

