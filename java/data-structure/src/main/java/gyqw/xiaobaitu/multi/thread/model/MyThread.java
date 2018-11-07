package gyqw.xiaobaitu.multi.thread.model;

/**
 * @author fred
 */
public class MyThread extends Thread {
    private static int num = 0;
    private String name;

    public MyThread(String name) {
        num++;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name + " 子线程ID:" + Thread.currentThread().getId());
    }
}
