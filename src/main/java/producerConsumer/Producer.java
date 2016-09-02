package producerConsumer;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicklas Molving
 */
public class Producer extends Thread{

    private BlockingQueue s1;
    private BlockingQueue s2;

    private long toCalc;
    private long res;
    
    private int taskID;
    private ArrayList<Thread> threads;
    
    public Producer(BlockingQueue s1, BlockingQueue s2, int id, ArrayList<Thread> threads) {
        this.s1 = s1;
        this.s2 = s2;
        taskID = id;
        this.threads = threads;
    }

    @Override
    public void run() {
        System.out.println("Thread " + taskID + "Started");
        long startTime = System.nanoTime();
        while(s1.size()>0){
            toCalc = (long) s1.poll();
            res = fib(toCalc);
            try {
                
                s2.put(res);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Task " + taskID + "has ended after: " + (endTime-startTime)/1000000 + " milliseconds");
        threads.remove(this);
//        this.interrupt();
        
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
