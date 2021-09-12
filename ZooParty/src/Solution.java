import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Animal {
    void walk(){
        System.out.println("I am walking.");
    }

    void swim(){
        System.out.println("I am swimming.");
    }

}

class Dog extends Animal{
    void sing(){
        System.out.println("Woof, woof.");
    }
}

class Cat extends Animal{
    void sing(){
        System.out.println("Meow.");
    }
}

class Bird extends Animal {
    void fly(){
        System.out.println("I am flying.");
    }

    void sing() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("I am singing.");
    }
}

class Duck extends Bird {
    @Override
    void sing() {
        System.out.println("Quack, quack.");
    }
}

class Chicken extends Bird {

    @Override
    void sing() {
        System.out.println("Cluck, cluck.");
    }

    @Override
    void fly() {
        System.out.println("Help! I cannot fly!");
    }
}

class Rooster extends Chicken{
    @Override
    void sing() {
        System.out.println("Cock-a-doodle-doo.");
    }
}

class Parrot extends Bird{
    private String liveWith;

    @Override
    void sing() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = liveWith.getClass();
        Method method = clazz.getMethod("sing");
        method.invoke(clazz.newInstance());
    }

    public void setLiveWith(String liveWith){
        this.liveWith = liveWith;
    }
}

class Fish extends Animal{
    @Override
    void walk() {
        System.out.println("I cannot walk.");
    }

    void sing(){
        System.out.println("I cannot sing.");
    }
}

class Shark extends Fish {
    void features(){
        System.out.println("I'm large and grey.");
    }
    void eat(Fish f){
        if (!(f instanceof Shark)){
            System.out.println("I am eating.");
        }
    }
}

class Clownfish extends Fish {
    void features(){
        System.out.println("I'm small and colourful.");
    }
    void joke(){
        System.out.println("I am joking.");
    }
}

class Dolhpin extends Animal{
    @Override
    void swim() {
        System.out.println("I'm a good swimmer.");
    }
}

class Butterfly extends Bird{
    private int age = 0;

    @Override
    void sing() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("...");
    }

    @Override
    void fly() {
        System.out.println("Of course I can fly. ");
    }

    @Override
    void walk() {
        if(this.age > 1){
            System.out.println("I cannot walk.");
        }
        else{
            System.out.println("I can walk.");
        }

    }

    public void setAge(int age){
        this.age = age;
    }
}

public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();

        Animal[] animals = new Animal[]{
                new Bird(),
                new Duck(),
                new Chicken(),
                new Rooster(),
                new Parrot(),
                new Fish(),
                new Shark(),
                new Clownfish(),
                new Dolhpin(),
                new Dog(),
                new Butterfly(),
                new Cat()
        };
    }
}
