import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JVM: stands for java virtual machine
 *
 * step1: System.out.println("hello world");
 * step2: java will compile your code -> using java compiler
 * step3: JavaDay4.java -> JavaDay4.class after compiling
 *
 * *********************JVM******************************************
 * [class loader -> will load your .class file into your jvm,]
 * [runtime data areas] -> memory for storing some information: local variable, parameters, objects, bytecode...
 * [execution engine] -> this will execute your .class file
 *
 * **********************JVM*****************************************
 *
 * step4: you will see "hello world"
 *
 *
 * memory:
 * memory area: this is a shared memory area where you can store your constant, static variable, class and method definitions
 *
 * heap: this is used to store objects.  shared
 *
 * stack: thread will use  stack. stack is used to store. return value, method invocations... not shared.
 *
 *in the heap, we have three components:
 * young generation
 *      eden space: 99.999999999% new created objects are stored in this memory
 *      survivor space(s0, s1)
 * old generation: store old objects after few gc
 * metaspace: class definitions, method definitions.
 *
 * how can we tell one object is alive or not
 * we are using gc root for most of time.
 * if some objects can be reached from gc root, then this object is alive. otherwise , it is dead.
 *
 * gc algorithm:
 *  one term: stop the world
 *  normal deletion gc:
 *[heap  [1],[],[2],[5],[3],[4][]] -> after deletion ->  [1],[],[2],[],[3],[4][]] -> you create a large object that takes two spaces ->
 *      you know there even have three spaces you can use, but you couldn't store this large object
 *
 * normal deletion - compact gc
 * [1],[],[2],[],[3],[4][]] ->[1],[2],[3],[4][][][] -> and now you can store large object
 *
 * this two gc have a lot of stop-the-world
 *
 * CMS concurrent mark and sweep: introduced in java 7 and removed in java 14
 *
 * initial mark (stw) -> a brief stop/ pause for application where it marks directly reachable objects from gc root
 *
 * concurrent mark: (do not need stw) -
 * while your application is running and mark all reachable objects
 *
 * remark (stw)
 * for this second stop/ pause, we just to catch objects that became unreachable while the step 2 phase was running
 *
 * concurrent sweep
 * removes all unused objects and clean up memory
 *
 * concurrent reset
 * ready for next gc
 *  advantages of cms: you will have low latency, bc you reduce application pause times
 *  concurrent execution: most of the work will run with application threads
 *
 *  disadvantages: of cms:
 *   it does not compact memory -> some problems with fragmentation
 *   cpu overhead
 *
 *   G1 gc
 *   [heap   [       yong          ][       old        ][metaspace]] -> with G1  ->
 *   [[][][][][][][][][][]] -> we call small space as region and each region can be young generation and old generation
 *
 *   young generation collection (stw)
 *      g1 will collect only yong generation regions (eden and survivor spaces)
 *
 *   concurrent mark
 *      initial mark (stw)
 *      concurrent mark
 *      remark (stw)
 *      cleanup
 *  mixed collection (young + old)
 *      g1 will collect both young and old regions in a mixed manner
 *
 *  last: compact phase:
 *      we are trying to avoid fragmentation here.
 *
 *
 *
 *compare to cms
 * this gc has compaction: g1 compacts memory on the fly, preventing fragmentation
 *
 *
 *
 * zgc: you can google it by yourself
 *
 *
 *
 *how many ways we can create a thread
 *1: extends thread
 * 2: implements runnable
 * 3: implements callable
 *
 *
 *
 *runnable vs callable
 * runnable:  it is a functional interface and you can create a thread
 * callable, it is a functional interface and you need give a return type and throws an exception
 *
 *
 *what are thread states
 * new: a thread just created, not run yet
 * runnable: a thread is running
 * blocked:a thread is waiting for a minor lock; like synchronized lock
 * waiting: a thread is waiting for another thread to perform something
 * timed waiting : a thread is waiting with a specified time for another threads
 * terminated: task is finished.
 *
 *
 * wait() vs sleep()
 * wait function will let current thread to wait and give up its hold on a shared rescourses
 * sleep function does not release shared resources
 *
 *
 * 1 13:46:09Thread-0 enter into test() function, and sleep for 1s
 * 2 13:46:10Thread-0 wake up now, and I will call wait() function for 2s
 * 3 13:46:10Thread-1 enter into test() function, and sleep for 1s
 * 4 13:46:11Thread-1 wake up now, and I will call wait() function for 2s
 * 5 13:46:12Thread-0 I am leaving now, but I need to sleep 10s
 * 6 13:46:22Thread-0 leave
 * 7 13:46:22Thread-1 I am leaving now, but I need to sleep 10s
 * 8 13:46:32Thread-1 leave
 *
 * run() vs start()
 * run(): will not create a new thread to execute your code -> will use main thread
 * start(): will create a new thread to execute your code -> main thread is not used
 *
 * run(): you can call run() with same thread many times, start()-> you only can call one time with same thread
 *
 * run() method: the code you defined will be executed immediately when you call run() function
 * start(): this method will need to wait cpu resources. which means your thread will need time to wait cpu resources
 *
 *
 *
 * volatile:
 * 1: make shared resources visible to other thread(s)
 * 2: prevent to reodering
 *
 *
 * [thread A]                                                       [thread B]
 *     |                                                                 |
 * [local memory A: shared resources replic]           [local memory B:shared resources replic]
 *          | ------------------------------JMM----------------------------|
 *          |                                                               |
 *     [                     main memory: shared resources                                  ]
 *
 * suppose you have .java file like this
 * int a = 10;
 * int b =  11;
 * int c = 12;
 *  int d = a + b;
 *  int e = c + d;
 *  after you compile you code in you .class file
 *
 *  * int c = 12;
 *  * int b =  11;
 *   * int a = 10;
 *  *  int d = a + b;
 *  *  int e = c + d;
 *
 *
 * after you adding volatile
 * * volatile int a = 10;
 *  * volatile int b =  11;
 *  * volatile int c = 12;
 *   volatile int d = a + b;
 *  *  volatile int e = c + d;
 *
 *
 *
 *
 *
 */
public class JavaDay4 {
    private AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) {// main  thread


        JavaDay4 javaDay4 = new JavaDay4();
        new Thread(javaDay4::test).start();//thread 0
        new Thread(javaDay4::test).start();// thread 1

    }
    private synchronized  void test(){
        try{
            log("enter into test() function, and sleep for 1s");
            Thread.sleep(1000);

            log("wake up now, and I will call wait() function for 2s");
            wait(2000);
            log("I am leaving now, but I need to sleep 10s");
            Thread.sleep(10000);
            log("leave");
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void log(String str){
        System.out.println( count.incrementAndGet() + " " + new Date().toString().split(" ")[3] +
                Thread.currentThread().getName() + " " + str);
    }
}
