public class Rest {
    final Object kit = new Object();
    final Object ord = new Object();
    final Object c = new Object();
    final Object w = new Object();
    long cooking = 3000;
    long eating = 2000;
    long beginning = 500;


    public void cook()  {
        System.out.println(Thread.currentThread().getName() + " на работе!");
        try {
            c.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waiter() {
        try {
            Thread.sleep(beginning);
            System.out.println(Thread.currentThread().getName() + " на работе!");
            w.wait();
            Thread.sleep(beginning * 3);
            order();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void visitor() {
        try {
            long[] myLong = new long[]{3000, 4000, 5000, 6000, 7000, 8000};
            int n = (int) Math.floor(Math.random() * myLong.length);
            Thread.sleep(myLong[n]);
            System.out.println(Thread.currentThread().getName() + " в ресторане");
            w.notify();
            System.out.println(Thread.currentThread().getName() + " приступил к еде");
            Thread.sleep(eating);
            System.out.println(Thread.currentThread().getName() + " вышел из ресторана");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void order() {
        System.out.println(Thread.currentThread().getName() + " принял заказ");
        kitchen();
        System.out.println(Thread.currentThread().getName() + " несет заказ");
    }

    public void kitchen() {
        synchronized (kit) {
            System.out.println("Повар готовит блюдо");
            try {
                Thread.sleep(cooking);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Повар закончил готовить");
            c.notify();
        }
    }
}