package producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Nicklas Molving
 */
public class TaskExecutor {
    
    

    
    public static void main(String[] args) {
        
        
        BlockingQueue<Long> s1 = new ArrayBlockingQueue(11);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue(11);
        fillQueue(s1);
        
        Observer observer = new ThreadMonitor();
        
        
        Thread t1 = new Producer(s1,s2, observer);
        Thread t2 = new Producer(s1,s2, observer);
        Thread t3 = new Producer(s1,s2, observer);
        Thread t4 = new Producer(s1,s2, observer);
        Thread t5 = new Consumer(s2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
        
        
    }
    
    private static void fillQueue(BlockingQueue que){
        
        
        que.add((long)4);
        que.add((long)5);
        que.add((long)8);
        que.add((long)12);
        que.add((long)21);
        que.add((long)22);
        que.add((long)34);
        que.add((long)35);
        que.add((long)36);
        que.add((long)37);
        que.add((long)42);
    }
}
