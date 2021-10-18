/**
 * java 1. Homework 5
 *
 * @version 25 sep 2021
 * @autor Anton_Mahin
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 * 4. * Добавить подсчет созданных котов, собак и животных.
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        Cat cat = new Cat(200, -1);
        Dog dog = new Dog(500, 10);
        AnimalInterface[] animals = {cat, dog};
        for (AnimalInterface animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(150));
            System.out.println(animal.run(250));
            System.out.println(animal.run(550));
            System.out.println(animal.swim(5));
            System.out.println(animal.swim(15));
        }
        System.out.println("Созданы животные " + cat.getCountOfAnimals());
    }
}

class Dog extends Animal {
    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
}

class Cat extends Animal {
    Cat(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }

    @Override
    public String swim(int distance) {
        return getClassName() + " не плавает";
    }
}

abstract class Animal implements AnimalInterface {
    private int runLimit;
    private int swimLimit;
    private String className;
    private static int couuntOfAnimals;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        couuntOfAnimals++;
    }

    public int getCountOfAnimals() {
        return couuntOfAnimals;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String run(int distance) {
        if (distance > runLimit) {
            return className + " не может пройти " + distance;
        } else {
            return className + " может пройти " + distance;
        }
    }

    @Override
    public String swim(int distance) {
        if (distance > swimLimit) {
            return className + " не может плавать " + distance;
        } else {
            return className + " может плавать " + distance;
        }
    }

    @Override
    public String toString() {
        return className + " .runLimit: " + runLimit + ", swimLimit: " + swimLimit;
    }
}

interface AnimalInterface {
    String run(int distance);

    String swim(int distance);
}