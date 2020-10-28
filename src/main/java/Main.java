public class Main {
    public static void main(String[] args) {
        Rest rest = new Rest();
        System.out.println("\nРесторан\n");
        System.out.println("Повар на работе!");

        ThreadGroup waiter = new ThreadGroup("офицанты");
        new Thread(waiter, rest::waiter, "Официант1").start();
        new Thread(waiter, rest::waiter, "Официант2").start();
        new Thread(waiter, rest::waiter, "Официант3").start();

        ThreadGroup visitor = new ThreadGroup("посетители");
        for (int i = 0; i < 5; i++) {
            int n = i + 1;
            new Thread(visitor, rest::visitor, "Посетитель" + n).start();
        }
    }
}