import org.w3c.dom.css.Rect;

class Animal{
    private int age, weight, height;
    void makeSound(){
        System.out.println("Random noise");
    }
    Animal(){
        System.out.println("Animal object created");
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}


class Cat extends Animal{
    void makeSound(){
        System.out.println("Cat meows");
    }
    void eatFood(){
        System.out.println("Cat is eating");
    }
}

class Dog extends Animal{
    void makeSound(){
        System.out.println("Dog barks");
    }
    void walk(){
        System.out.println("Dog loves to walk");
    }
    void eatFood(){
        System.out.println("Dog is eating");
    }
}
public class Main {

    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        a.makeSound();
        d.makeSound();
        d.walk();
        Animal a2 = new Dog();
        a2.makeSound();
        ((Dog)a2).walk();
        // Pet shop:
        Animal [] arr = new Animal[5];
        arr[0] = new Dog();
        arr[1] = new Cat();
        arr[2] = new Cat();
        arr[3] = new Dog();
        arr[4] = new Cat();
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] instanceof Cat)
                ((Cat)arr[i]).eatFood();
            else ((Dog)arr[i]).eatFood();
        }
    }
}