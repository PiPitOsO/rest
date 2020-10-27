import java.util.ArrayList;

public class K {
    ArrayList<Runnable> orders = new ArrayList<>();
    public synchronized Runnable get () {
        while (orders.isEmpty()) {
            try {
                wait();
                System.out.println("Повар готовит блюдо");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Повар закончил готовить");
        }
        Runnable order = orders.get(0);
        orders.remove(order);
        return order;
    }
    public synchronized void put (Runnable order) {
        orders.add(order);
        notify();
    }
}