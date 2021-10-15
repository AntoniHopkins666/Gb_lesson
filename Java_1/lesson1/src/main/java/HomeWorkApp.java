/**
 * java 1. Homework 1
 *
 * @autor Anton_Mahin
 * @version 12 sep 2021
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();// 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
        System.out.println (checkSumSign (2,-4)); //Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консольсообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
        printColor (1); // Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
        System.out.println (compareNumbers (10,5));// Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    }
    static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    static String checkSumSign (int a, int b){
            return ("Сумма " + (a + b >= 0? "положительная" : "отрицательная"));
        }
    static void printColor (int value){
        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }
    static String compareNumbers (int a, int b) {
        return a >= b? "a >= b" : "a < b";
    }
}
