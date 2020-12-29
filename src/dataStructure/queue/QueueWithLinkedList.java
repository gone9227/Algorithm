package dataStructure.queue;

import java.util.LinkedList;

public class QueueWithLinkedList {
    public static void main(String[] args) {
        Dog d1 = new Dog("puppy");
        Dog d2 = new Dog("chichi");
        Dog d3 = new Dog("chacha");
        Cat c1 = new Cat("Coco");
        Cat c2 = new Cat("Aka");
        Cat c3 = new Cat("Puffy");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(c1);
        as.enqueue(d1);
        as.enqueue(d3);
        as.enqueue(c3);
        as.enqueue(c2);
        as.enqueue(d2);

        System.out.println(as.dequeue().info());
        System.out.println(as.dequeueCat().info());
        System.out.println(as.dequeueDog().info());
        System.out.println(as.dequeue().info());
    }

}

enum AnimalType{
    DOG, CAT;
}

abstract class Animal{
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name){
        this.type = type;
        this.name = name;
    }

    public int getOrder(){
        return this.order;
    }

    public void setOrder(int order){
        this.order = order;
    }

    public String info(){
        return order + ") Type : " + type + " , name : " + name;
    }
}

class Dog extends Animal{
    Dog(String name){
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal{
    Cat(String name){
        super(AnimalType.CAT, name);
    }
}

class AnimalShelter{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    int order;

    public AnimalShelter(){
        order = 1;
    }

    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;
        if(animal.type.equals(AnimalType.DOG)){
            dogs.addLast((Dog)animal);
        }else if(animal.type.equals(AnimalType.CAT)){
            cats.add((Cat)animal);
        }
    }

    public Animal dequeueDog(){
        return dogs.poll();
    }

    public Animal dequeueCat(){
        return cats.poll();
    }

    public Animal dequeue(){
        if(dogs.size() == 0 && cats.size() == 0){
            return null;
        }else if(dogs.size() == 0){
            return cats.poll();
        }else if(cats.size() == 0){
            return dogs.poll();
        }
        return dogs.peek().order < cats.peek().order ? dogs.poll() : cats.poll();
    }
}