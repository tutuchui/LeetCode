package concurrent;

import hsbcinterview.HSBCQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainPrinter {


    public static void main(String[] args) {
        List<Condition> conditions = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
//            Thread thread = new Thread(new NumberPrintWithReentrantLock(i, 3));
            Thread thread = new Thread(new NumberPrinter(i));
            thread.start();
        }
    }
}
