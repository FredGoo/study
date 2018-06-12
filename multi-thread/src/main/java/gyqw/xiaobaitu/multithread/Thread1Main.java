package gyqw.xiaobaitu.multithread;

/**
 * @author fred
 * @date 2018/06/12 15:03
 */
public class Thread1Main implements Runnable {
    private int num;
    private final Object lock;

    private Thread1Main(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                    this.lock.wait();
                    System.out.println(this.num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();

        Thread thread1 = new Thread(new Thread1Main(1, lock));
        Thread thread2 = new Thread(new Thread1Main(2, lock));

        thread1.start();
        thread2.start();
    }
}
