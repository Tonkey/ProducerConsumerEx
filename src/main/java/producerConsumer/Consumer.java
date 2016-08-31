package producerConsumer;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicklas Molving
 */
public class Consumer extends Thread{

    
    private BlockingQueue s2;
    private long toPrint;
    private long sumOfS2 = 0;
    private long timer = 15;
    private ArrayList<Thread> threads;
    public Consumer(BlockingQueue s2, ArrayList<Thread> threads){
        this.s2 = s2;
        this.threads = threads;
    }
    
    @Override
    public void run() {
        int count = 0;
        while(!threads.isEmpty()){
            
                try {
                    toPrint = (long) s2.take();
                    sumOfS2 += toPrint;
                    count++;
                System.out.println(toPrint);
            
                
                
            } catch (InterruptedException ex) {
                
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Final count: " + sumOfS2);
        
    }

}
