class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.printf("%s на работе!\n", getName());
    }
}