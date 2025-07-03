package concurrent;

import hsbcinterview.HSBCQueue;

import java.util.HashMap;


public class NumberPrinter implements Runnable {

    private static volatile Integer counter = 0;

    private static final Object PRINT_LOCK = new Object();

    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    HashMap

    @Override
    public void run() {
        while(true) {
            synchronized (PRINT_LOCK) {
                try {
                    while(counter % 3 != number && counter < 101) {
                        PRINT_LOCK.wait();
                    }
                    if(counter < 101) {
                        System.out.println("Thread index: " + number + " print: " + counter);
                    }else{
                        System.out.println("Thread index: " + number + " exit");
                        return;
                    }
                    counter++;
                    PRINT_LOCK.notifyAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
