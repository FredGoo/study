package gyqw.xiaobaitu.multithread;

import gyqw.xiaobaitu.multithread.model.MyThread;

/**
 * @author fred
 */
public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程ID:" + Thread.currentThread().getId());

        MyThread thread1 = new MyThread("thread-start");
        System.out.println("thread1 isAlive: " + thread1.isAlive());
        thread1.start();
        System.out.println("thread1 isAlive: " + thread1.isAlive());
        Thread.sleep(1000);
        System.out.println("主线程结束 isAlive: " + thread1.isAlive());
    }

}
