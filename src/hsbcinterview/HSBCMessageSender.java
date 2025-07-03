package hsbcinterview;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class HSBCMessageSender {

    public static Queue<HSBCMessage> MESSAGE_QUEUE = new ConcurrentLinkedQueue<>();


    public void send() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HSBCMessage message = new HSBCMessage();
            message.setId(UUID.randomUUID().toString());
            message.setContent("RequestContent: " + message.getId());
            message.setRequestTime(new Date());
            System.out.println("send message: " + message.getContent());
            MESSAGE_QUEUE.add(message);
        }

    }

    public void receive() {
        while (true) {
            if (MESSAGE_QUEUE.isEmpty()) {
//                System.out.println("no message");
                continue;
            }
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
//            RESPONSE_QUEUE.add(message);
        }
    }

}
