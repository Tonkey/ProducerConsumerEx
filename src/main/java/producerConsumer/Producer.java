package producerConsumer;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicklas Molving
 */
public class Producer extends Thread implements Subject{

    private BlockingQueue s1;
    private BlockingQueue s2;

    private long toCalc;
    private long res;
    
    private ArrayList<Observer> observers = new ArrayList();
    
    public Producer(BlockingQueue s1, BlockingQueue s2, Observer o) {
        this.s1 = s1;
        this.s2 = s2;
        
    }

    @Override
    public void run() {
        while(s1.size()>0){
            toCalc = (long) s1.poll();
            res = fib(toCalc);
            try {
                
                s2.put(res);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("no more numbers to be calculated!");
        
        
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        //not used in this example
    }

    @Override
    public void notifyObserver() {
        
    }

}
