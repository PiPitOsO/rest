import java.util.ArrayList;

public class Rest {
    final Object kit = new Object();
    final Object ord = new Object();
    final Object c = new Object();
    final Object w = new Object();
    long cooking = 3000;
    long eating = 2000;
    long beginning = 500;
    ArrayList<Runnable> orders = new ArrayList<>();


    public void waiter() {
        try {
            Thread.sleep(beginning);
            System.out.println(Thread.currentThread().getName() + " на работе!");
            synchronized (kit) {
                kit.wait();
            }
            acceptanceOrder();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void visitor() {
        try {
            long[] myLong = new long[]{3000, 4000, 5000, 2000, 1500, 2500};
            int n = (int) Math.floor(Math.random() * myLong.length);
            Thread.sleep(myLong[n]);
            System.out.println(Thread.currentThread().getName() + " в ресторане");
            synchronized (kit) {
                long[] orderT = new long[]{500, 1000, 1500};
                int o = (int) Math.floor(Math.random() * orderT.length);
                Thread.sleep(orderT[o]);
                System.out.println(Thread.currentThread().getName() + " готов сделать заказ");
                notify();
            }
//            putOrder();
//            orders.add(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptanceOrder() {
        System.out.println(Thread.currentThread().getName() + " принял заказ");
    }

    public void deliveryOrder() {
        System.out.println(Thread.currentThread().getName() + " несет заказ");
    }

    public void meal() {
        try {
            System.out.println(Thread.currentThread().getName() + " приступил к еде");
            Thread.sleep(eating);
            System.out.println(Thread.currentThread().getName() + " вышел из ресторана");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Runnable get() {
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

    public synchronized void putOrder(Runnable order) {
        orders.add(order);
        notify();
    }
}
