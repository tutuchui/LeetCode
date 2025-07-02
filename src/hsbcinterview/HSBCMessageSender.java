package hsbcinterview;

import java.util.Date;
import java.util.UUID;

public class HSBCMessageSender {

    public void send() {
        while(true){
            try{
                Thread.sleep(3 * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            HSBCMessage message = new HSBCMessage();
            message.setId(UUID.randomUUID().toString());
            message.setContent("RequestContent: " + message.getId());
            message.setRequestTime(new Date());
            System.out.println("send message: " + message.getContent());
            HSBCQueue.MESSAGE_QUEUE.add(message);
        }

    }

}
