package gyqw.xiaobaitu.multithread;

import gyqw.xiaobaitu.multithread.model.MyThread;

/**
 * @author fred
 */
public class ThreadMain {
    public static void main(String[] args) {
        System.out.println("主线程ID:" + Thread.currentThread().getId());

        MyThread thread1 = new MyThread("thread-start");
        thread1.start();
        MyThread thread2 = new MyThread("thread-run");
        thread2.run();
    }

}
