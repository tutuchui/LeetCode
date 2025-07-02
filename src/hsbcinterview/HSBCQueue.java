package hsbcinterview;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class HSBCQueue {
    public static volatile Queue<HSBCMessage> MESSAGE_QUEUE = new LinkedBlockingQueue<>();
    public static volatile Queue<HSBCMessage> RESPONSE_QUEUE = new LinkedBlockingQueue<>();
}
