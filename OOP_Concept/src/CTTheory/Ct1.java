package CTTheory;

//public class Ct1 {
//    int x,y;
//    static int s;
//    Ct1(int x,int y){
//        this.x=x;
//        this.y=y;
//        System.out.println("Hello");
//    }
//
//    static void main(String[] args) {
//        Ct1 obj=new Ct1(4,6);
//        Ct1 obj2=new Ct1(10,20);
//        System.out.println(obj.x);
//        System.out.println(obj2.y);
//        Ct1.s=40;
//        System.out.println(Ct1.s);
//    }
//
//}

//class Point2{
//    int x;
//    int y;
//    Point2(int x,int y){
//        this.x=x;
//        this.y=y;
//    }
//    void right(){
//        this.x=this.x+1;
//    }
//    void left(){
//        this.y=this.y+1;
//    }
//    void show(){
//        System.out.println("X: " + this.x +" Y: "+this.y);
//    }
//
//    static void main(String[] args) {
//        Point2 p1=new Point2(4,6);
//        Point2 p2=new Point2(60,20);
//        p1.left();
//        p1.show();
//        p1.right();
//        p1.show();
//    }
//
//}

class Point1{
    int x,y;
    Point1(int x,int y){
        this.x=x;
        this.y=y;
    }
    double distance1(Point1 p){
        int a=this.x;
        int b=this.y;
        int c=p.x;
        int d=p.y;

        return Math.sqrt((a-c)*(a-c)+(b-d)*(b-d));
    }
}
class Circle1{
    Point1 center;
    double radius;
    Circle1(Point1 center, double radius){
        this.center=center;
        this.radius=radius;
    }
    void check1(Point1 p){
        double dist=p.distance1(this.center);
        if(dist>this.radius){
            System.out.println("Outside");
        }
        else{
            System.out.println("Inside");
        }
    }
}

class Test1{
    static void main(String[] args) {
        Point1 p=new Point1(4,6);
        double radius=6;
        Circle1 c=new Circle1(p,radius);
        Point1 p1=new Point1(6,7);
        c.check1(p1);
    }
}