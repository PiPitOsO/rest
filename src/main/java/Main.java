public class Main {
    public static void main(String[] args) {
        Rest rest = new Rest();
        System.out.println("\nРесторан\n");

        new Thread(null, rest::cook, "Повар").start();

        ThreadGroup waiter = new ThreadGroup("офицанты");
        new Thread(waiter, rest::waiter, "Официант1").start();
        new Thread(waiter, rest::waiter, "Официант2").start();
        new Thread(waiter, rest::waiter, "Официант3").start();

        ThreadGroup visitor = new ThreadGroup("посетители");
        new Thread(visitor, rest::visitor, "Посетитель1").start();
        new Thread(visitor, rest::visitor, "Посетитель2").start();
        new Thread(visitor, rest::visitor, "Посетитель3").start();
        new Thread(visitor, rest::visitor, "Посетитель4").start();
        new Thread(visitor, rest::visitor, "Посетитель5").start();





    }
}