package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrintWithReentrantLock implements Runnable {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static List<Condition> conditions = new ArrayList<>();

    private static volatile int COUNTER = 0;

    private int index;

    public NumberPrintWithReentrantLock(int index, int workerCount) {
        if(conditions.size() < workerCount) {
            for(int i = 0; i < workerCount - conditions.size(); i++ ) {
                conditions.add(LOCK.newCondition());
            }
        }
        this.index = index;
    }

    @Override
    public void run() {
        while(true) {
            LOCK.lock();
            try {
                while(COUNTER % 3 != index && COUNTER < 101) {
                    conditions.get(index).await();
                }
                if(COUNTER < 101) {
                    System.out.println("Thread index: " + index + " print: " + COUNTER);
                    COUNTER++;
                }else{
                    conditions.forEach(condition -> condition.signalAll());
                    System.out.println("Thread index: " + index + " exit");
                    return;
                }
                int nextIndex = COUNTER % 3;
                conditions.get(nextIndex).signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                LOCK.unlock();
            }

        }
    }
}
