package hsbcinterview;

public class HSBCMain {
    public static void main(String[] args) {
        HSBCMessageSender hsbcMessageSender = new HSBCMessageSender();
        Thread sendThread = new Thread(() -> {
            hsbcMessageSender.send();
        });
        sendThread.start();
        HSBCMessageSender hsbcMessageSender1 = new HSBCMessageSender();
        Thread receiveThread = new Thread(() -> {
            hsbcMessageSender1.receive();
        });
        receiveThread.start();
//        HSBCMonitor hsbcMonitor = new HSBCMonitor();
//        Thread monitorThread = new Thread(() -> {
//            hsbcMonitor.monitor();
//        });

//        monitorThread.start();
    }
}
