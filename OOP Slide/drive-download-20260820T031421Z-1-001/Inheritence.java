class Animal{
    int age;
    int height = 100;
    void make_sound(){
        System.out.println("Random noise");
    }
    Animal(int age){
        this.age = age;
    }


    void allInfo(){
        System.out.println("Age " + age);
        System.out.println("Height " + height);
        make_sound();
    }
}

class Dog extends Animal{
    String breed;
    void make_sound(){
        System.out.println("Bark");
    }
}

class PetDog extends Dog{
    PetDog(){

    }
}

class Cat extends Animal{
    void make_sound(){
        System.out.println("Meow");
    }
}


class Main {
    public static void main(String args[]) {
        Dog d = new Dog(10);
        d.height = 50;
        d.allInfo();
    }
}


