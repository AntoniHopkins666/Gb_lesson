/**
 * java 1. Homework 5
 *
 * @version 24 sep 2021
 * @autor Anton_Mahin
 * <p>
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 * 6. Инкапсуляция! private!
 * 7. Переопределение метода toString()!
 */

public class HomeWorkApp {
    public static void main(String[] args) {
        Employee[] empCompany = new Employee[5];
        empCompany[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231212", 30000, 35);
        empCompany[1] = new Employee("Sidorov Ivan", "Engineer", "siivan@mailbox.com", "8923648788", 35000, 41);
        empCompany[2] = new Employee("Dementiev Viktor", "Engineer", "dviktor@mailbox.com", "89236334768", 37000, 33);
        empCompany[3] = new Employee("Leshenko Dmitrii", "Engineer", "leshdmitrii@mailbox.com", "89233123121", 39000, 27);
        empCompany[4] = new Employee("Petrov Ivan", "Engineer", "peivan@mailbox.com", "89236542143", 50000, 52);
        for (Employee employee : empCompany)
            if (employee.getAge() > 40)
                System.out.println(employee);
    }
}

class Employee {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String telephone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return (name + " " + position + " " + email + " " + telephone + " " + salary + " " + age);
    }
}
