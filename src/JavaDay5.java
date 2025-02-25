import sun.lwawt.macosx.CSystemTray;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * day 5 : CAS: it stands for compare and swap(set)
 *
 * what is atomic operation:
 * atomic operation,  it is an unit of operations(like your code) always execute togehter, or
 * none of them executes
 *
 * memory location(V): this is address of variable to update
 * expected old value(A): the value you want to see and compare
 * new value(B): the value we want to update
 *
 *
 *ABA problem: you can solve this problem by using atomicstampedreference
 * -----------------time line--------------
 * thread A--start--------------------------------------------------------------------------------try to change value V at the time 2-------------
 *              thread B--- start--update value and finished  at time time 0--and change back to original value at the time 1---
 *
 *thread safe collections
 *
 * concurrent hashmap:
 * thread safe and you are NOT allow to have null value for key and value in concurrent hashmap
 * not all functions are synchronized
 *
 *
 * blocking queue, it is thread safe and we can use it by producer - consumer model.
 *
 *                  takeIndex
 *                  [1][2][3][4][5][6][7][8]
 *                  putIndex
 *
 *
 * the drawbacks of synchronized
 * 1: decreased performance:
 * 2: deadlock: if two or more threads  are waiting for each other to release a lock, then a deadlock can occur
 * 3: hard to debug
 *
 *
 * we have two different lockers
 * 1: pessimistic locker: only allows one thread to access and modify the shared resources: synchronized, reentrantlock
 * 2:optimistic locker: allow multiple thread to access, but only one thread to modify:atomic
 *
 *
 * thread pool:
 *
 * Executor vs executorService executors
 * executor: allows you to run a runnable task
 * executorservice: allows you ro control your tasks
 *executors: allows you to create different thread pool
 *
 *
 *  fixed - size thread pool:
 *      number of thread is fixed.
 *
 *  cached thread pool
 *      will create and remove thread automatically
 *      may have a negative impact on performance if too many threads are created and destroyed frequently
 *
 *  single thread pool - only thread
 *
 *  4: fork - join pool : it is using work stealing pool
 *   it can be used for dividing large tasks into smaller sub tasks that can be executed in parallel.
 *
 *
 *
 *
 *
 */
public class JavaDay5 {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int expectedValue = 3;
        int newValue = 1;
        System.out.println("result is " + atomicInteger.compareAndSet(expectedValue, newValue));

        JavaDay5 javaDay5 = new JavaDay5();
        Thread producerThread = new Thread(()->{
            try{
                javaDay5.produer();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(()->{
            try{
                javaDay5.consumer();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();



    }

    public void produer() throws InterruptedException{
        int value = 0;
        while(true){
            System.out.println("producer: " + value);
            queue.put(value);
            value++;
        }

    }
    public void consumer() throws InterruptedException{
        while(true){
            if(queue.size() == 10){
                int value = queue.take();
                System.out.println("consumer: " + value);
                Thread.sleep(1000);
            }
        }
    }

}
