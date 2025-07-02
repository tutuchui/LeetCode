package hsbcinterview;

import java.util.Date;

import static hsbcinterview.HSBCQueue.RESPONSE_QUEUE;

public class HSBCMonitor  {
    public void monitor() {
        while (true) {
            if(RESPONSE_QUEUE.size() == 0) {
                continue;
            }
            HSBCMessage message = RESPONSE_QUEUE.poll();
            if(message.getResponseTime().getTime() - message.getRequestTime().getTime() > 5000) {
                System.out.println("Monitor: " + message.getId() + " waiting for response timeout");
            }else {
                System.out.println("Monitor: " + message.getContent() + " successfully processed");
            }
        }
    }
}
