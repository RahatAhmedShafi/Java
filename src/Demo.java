public class Demo {
    int num=100;

}
class Person{
    String name;
    int age;
    int money;
    void person1(String name, int age){
        this.name=name;
        this.age=age;
    }
    void person1(String name, int age,int money){
        this.name=name;
        this.age=age;
        this.money=money;
    }
}
class student{
    static void main(String[] args) {
        Demo obj = new Demo();
        System.out.println(obj.num);
    }
}
