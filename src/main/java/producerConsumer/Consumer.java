package producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
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
    public Consumer(BlockingQueue s2){
        this.s2 = s2;
    }
    
    @Override
    public void run() {
        int count = 0;
        while(count < 11){
            
                try {
                    toPrint = (long) s2.take();
                    sumOfS2 += toPrint;
                    count++;
                System.out.println(toPrint);
            
                
                
            
//            System.out.println("Final sum of all numbers: " + sumOfS2);
            } catch (InterruptedException ex) {
                
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Final count: " + sumOfS2);
        
    }

}
