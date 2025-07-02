package hsbcinterview;

public class HSBCMain {
    public static void main(String[] args) {
        HSBCMessageSender hsbcMessageSender = new HSBCMessageSender();
        Thread sendThread = new Thread(() -> {
            hsbcMessageSender.send();
        });
        sendThread.start();
        HSBCRecevier hsbcRecevier = new HSBCRecevier();
        Thread receiveThread = new Thread(() -> {
            hsbcRecevier.receive();
        });
        receiveThread.start();
        HSBCMonitor hsbcMonitor = new HSBCMonitor();
        Thread monitorThread = new Thread(() -> {
            hsbcMonitor.monitor();
        });

        monitorThread.start();
    }
}
