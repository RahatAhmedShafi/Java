public class Main {
    int num;

    static void mymethod(){ // This is Method
        System.out.println("Welcome to Java");
    }
    public Main(int num){ //This is Constructors
         this.num=num;
    }

    public static void main(String[] args) {
        First myobj=new First(); // Object creation
        Main myobj2=new Main(200);
        myobj.x=100;
        System.out.println(myobj.x);
        mymethod();
        System.out.println(myobj2.num);
    }
}
