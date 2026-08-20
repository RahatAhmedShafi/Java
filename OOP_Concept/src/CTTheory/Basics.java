package CTTheory;

class Point{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    double distance(Point p){
        int a=this.x;
        int b=this.y;
        int c=p.x;
        int d=p.y;

        return Math.sqrt((a-c)*(a-c)+(b-d)*(b-d));

    }
}

class Circle{
    Point center;
    double radius;

    Circle(Point center, double radius){
        this.center=center;
        this.radius=radius;
    }
    void check(Point p){
        double dist=p.distance(this.center);
        if(dist>this.radius){
            System.out.println("Outside the Circle");
        }
        else{
            System.out.println("Inside the circle");
        }
    }
}

class Test{
    static void main() {
        Point center=new Point(4,6);
        double radius=10;
        Circle c=new Circle(center,radius);
        Point p1=new Point(100,100);
        c.check(p1);
    }
}