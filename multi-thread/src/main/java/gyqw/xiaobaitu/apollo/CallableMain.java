package gyqw.xiaobaitu.apollo;

import gyqw.xiaobaitu.apollo.model.MyCallable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author fred
 */
public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("程序开始 线程号: " + Thread.currentThread().getId());
        Date startTime = new Date();

        int taskSize = 5;
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建返回任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i);
            Future f = pool.submit(c);
            list.add(f);
            Thread.sleep(500);
        }
        pool.shutdown();

        for (Future f : list) {
            System.out.println(f.get().toString());
        }

        Date endTime = new Date();
        System.out.println("程序结束 共运行: " + (endTime.getTime() - startTime.getTime()));
    }
}
