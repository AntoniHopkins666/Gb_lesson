public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Water(3), new Wall(5)); // Создаем полосу препятствий
        Team team = new Team("Heroes", new Human("Johny"), new Cat("Murzik"), new Dog("Izzy")); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу

        System.out.println("\nWinners:");
        team.passedTheDistance();

        System.out.println("\nResult:");// Показываем результаты
        team.showResults();
    }
}

abstract class Barrier {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Barrier {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}

class Water extends Barrier {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}

class Cross extends Barrier {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}

interface Competitor {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    boolean isOnDistance();

    void info();
}

class Human implements Competitor {

    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 30;
        this.maxSwimDistance = 200;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " successfully run");
        } else {
            System.out.println(name + " failed ran");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(name + " successfully swim");
        } else {
            System.out.println(name + " failed swimming");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " successfully jump");
        } else {
            System.out.println(name + " failed jump");
            active = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }
}

class Animal implements Competitor {

    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " successfully run");
        } else {
            System.out.println(type + " " + name + " failed run");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " successfully swim");
        } else {
            System.out.println(type + " " + name + " failed swimming");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " successfully jump");
        } else {
            System.out.println(type + " " + name + " failed jump");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " + onDistance);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super("Cat", name, 200, 20, 2);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super("Dog", name, 300, 40, 4);
    }
}

class Course {
    Barrier[] course = new Barrier[3];

    // Создаем полосу препятствий
    public Course(Barrier b1, Barrier b2, Barrier b3) {
        course[0] = b1;
        course[1] = b2;
        course[2] = b3;
    }

    // Метод, который просит всю команду пройти полосу препятствий
    public void doIt(Team t) {
        System.out.println("\nTeam \"" + t.nameTeam + "\":\n");
        // Для каждого участника команды
        for (Competitor com : t.getTeammates()) {
            // Для каждого препятствия вызываем метод его прохождения текущим участником команды
            for (Barrier b : course) {
                b.doIt(com);
            }
        }
    }
}

class Team {

    String nameTeam;


    Competitor[] partner = new Competitor[3];
    Animal[] zoo = {new Cat("Murzik"), new Dog("Izzy")};

    // Формируем команду
    public Team(String nameTeam, Competitor com1, Competitor com2, Competitor com3) {
        this.nameTeam = nameTeam;

        partner[0] = com1;
        partner[1] = com2;
        partner[2] = com3;

    }

    // Вывод информации кто прошел дистанцию
    public void passedTheDistance() {
        for (Competitor com : partner) {
            // Если участник onDistance == true, выводим его
            if (com.isOnDistance()) {
                com.info();
            }
        }
    }

    // Вывод информации о членах команды
    public void showResults() {
        for (Competitor com : partner) {
            com.info();
        }
    }

    // геттер участников команды
    public Competitor[] getTeammates() {
        return partner;
    }
}