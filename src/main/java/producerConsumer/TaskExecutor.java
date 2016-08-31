package producerConsumer;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Nicklas Molving
 */
public class TaskExecutor {
    
    /**
     * so basically what happens is that the higher the fib number, the longer it takes to compute
     * and the first thread to start will be the last to end as it will go through the early numbers fast
     * 
     * @param args 
     */

    
    public static void main(String[] args) {
        //amount of numbers to compute
        int n = 12;
        
        
        ArrayList<Thread> taskThreads = new ArrayList();
        BlockingQueue<Long> s1 = new ArrayBlockingQueue(n);
        BlockingQueue<Long> s2 = new ArrayBlockingQueue(n);
        fillQueue(s1);
        
        
        
        startThreads(4, s1, s2, taskThreads);
//        Thread t1 = new Producer(s1,s2);
//        Thread t2 = new Producer(s1,s2);
//        Thread t3 = new Producer(s1,s2);
//        Thread t4 = new Producer(s1,s2);
        Thread t5 = new Consumer(s2, taskThreads);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
        t5.start();
        
        
        
    }
    
    private static void startThreads(int n, BlockingQueue s1, BlockingQueue s2, ArrayList<Thread> arr){
        for(int i = 1; i <=n; i++){
            Thread t = new Producer(s1, s2, i, arr);
            arr.add(t);
            t.start();
        }
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
        que.add((long)43);
    }
}
