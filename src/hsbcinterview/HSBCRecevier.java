package hsbcinterview;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

import static hsbcinterview.HSBCQueue.MESSAGE_QUEUE;
import static hsbcinterview.HSBCQueue.RESPONSE_QUEUE;

public class HSBCRecevier {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                    // 核心线程数 corePoolSize
            5,                    // 最大线程数 maximumPoolSize
            60,                   // 空闲线程等待时间 keepAliveTime
            TimeUnit.SECONDS,     // 时间单位
            new ArrayBlockingQueue<>(10),  // 任务队列
            Executors.defaultThreadFactory(), // 线程工厂
            new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
    );


    public void receive() {
        while (true) {
            if (MESSAGE_QUEUE.size() == 0) {
//                System.out.println("no message");
                continue;
            };
            executor.execute(() -> {
                HSBCMessage message = MESSAGE_QUEUE.poll();
                System.out.println("receive message: " + message.getContent());
                int min = 1;
                int max = 8;
                Random random = new Random();

                int executionTime = random.nextInt((max - min) + 1) + min;
                try {
                    Thread.sleep(executionTime * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message.getId() + " executed " + executionTime + " seconds");
                message.setResponseTime(new Date());
                RESPONSE_QUEUE.add(message);
            });
        }
    }
}
