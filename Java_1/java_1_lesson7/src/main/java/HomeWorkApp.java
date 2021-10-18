/**
 * java 1. Homework 7
 *
 * @version 07 oct 2021
 * @autor Anton_Mahin
 * <p>
 * 1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
 * (например, в миске 10 еды, а кот пытается покушать 15-20).
 * 2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
 * удалось покушать (хватило еды), сытость = true.
 * 3. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
 * наполовину сыт (это сделано для упрощения логики программы).
 * 4. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
 * потом вывести информацию о сытости котов в консоль.
 * 5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */

import java.util.Scanner;

public class HomeWorkApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int action;
        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Василий", 12, false);
        allCats[1] = new Cat("Алиса", 10, false);
        allCats[2] = new Cat("Мурзик", 10, false);
        allCats[3] = new Cat("Барсик", 30, false);
        Plate plate = new Plate(50);
        plate.info();
        for (int i = 0; i < allCats.length; i++) {
            if (allCats[i].fullness == false && allCats[i].appetite < plate.food) {
                allCats[i].eat(plate);
                allCats[i].fullness = true;
                System.out.println("Котик " + allCats[i].name + " покушал!");
            } else {
                System.out.println("Котик " + allCats[i].name + " не поел!");
            }
        }
        plate.info();
        System.out.println("Сколько еды добавить еще в миску?");
        action = sc.nextInt();
        plate.increaseFood(action);
        plate.info();
    }
}

class Cat {
    String name;
    int appetite;
    boolean fullness;

    Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}

class Plate {
    int food;

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood(int x) {
        food += x;
    }

    void info() {
        System.out.println("Всего еды: " + food);
    }
}
