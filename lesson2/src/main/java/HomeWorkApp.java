/**
 * java 1. Homework 2
 *
 * @autor Anton_Mahin
 * @version 12 sep 2021
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println (metod1 (5,15)); // 1.Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
        metod2 (-1); // 2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
        System.out.println (metod3 (-1)); // 3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
        metod4 (); // 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
        metod5 (100); // 5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    }
    static boolean metod1 (int a, int b){
        int summ = a + b;
        if (summ >=10 && summ <= 20){
            return true;
        }
        else {
            return false;
        }
    }

    static void metod2 (int a){
        if(a < 0){
            System.out.println ("Число отрицательное");
        }
        else {
            System.out.println ("Число положительное");
        }
    }

    static boolean metod3 (int a){
        if (a < 0){
            return true;
        }
        else{
            return false;
        }
    }

    static void metod4 () {
            for (int j = 0; j < 3; j++) {
                System.out.println("Hello World!");
            }
        }

    static void metod5(int year) {
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) {
            System.out.println(year + " год не високосный");
        }
        else {
            System.out.println(year + " год високосный");
        }
    }
}
