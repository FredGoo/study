package gyqw.xiaobaitu.multithread.model;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author fred
 */
public class MyCallable implements Callable<Object> {
    private int taskNum;

    public MyCallable(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("任务启动 num: " + this.taskNum);
        Date startTime = new Date();
        Thread.sleep(1000);
        Date endTime = new Date();
        long time = endTime.getTime() - startTime.getTime();
        System.out.println("任务结束 num: " + this.taskNum);
        return "任务结束 num: " + this.taskNum + " 任务时间(毫秒): " + time + " 线程号: " + Thread.currentThread().getId();
    }
}
