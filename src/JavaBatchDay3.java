import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Day 3
 *
 * stream api
 *  it allows you to perform aggregate operations on java collections
 *  intermediate functions
 *  filter():selects all elements that math your predicate (condition) -> if statement
 *  map() transforms -> new type
 *  flatmap
 *  distinct()
 *  limit()
 *  skip
 *  sorted()....
 *
 *  terminal functions.
 *  foreach()
 *  reduce()
 *  collect
 *  min
 *  max
 *  count
 *  anyMatch
 *  allmatch
 *  nonematch
 *  ....
 *
 *  collections vs stream api
 *  collections: this is a data structures that stores and manipulate data in MEMORY whereas stream
 *                does not store data in memory and it is just a tool that allows you to use
 *  collections: java collections can be changed by adding or removing.. elements. whereas stream
 *              operations does not change the original data, but you can create another java collection or new stream api
 *
 *   parallel stream api:  it can use this when your dataset is very large!!
 *          it leverages fork join pool(contains a lot of predefined threads)
 *
 *
 * lambda function
 *  ()-> System.out.print("Hello lambda function")
 *  (a,b) -> a +b;
 *  before java 8
 *  new Thread(new Runnable(){
 *
 * @Override
 * public void run(){
 *     // your businnes logic
 *
 * }
 *  }).start()
 *  after java 8
 *  new Thread(()->System.out.print("Hello lambda function")).start();
 *
 * functional interface: it is an interface with functionalinterface annotation and one method
 *  allows you to use lambda function
 *
 *  optional: use to avoid null pointer exception
 *  private Optional<String> mypassword = "1231234123";
 *
 *  method reference: a short version of lambda function
 *  1: reference to a static method
 *          Integer::max
 *          String::length
 *
 *  2: reference to method of a particular object
 *      String myString = "123"
 *      myString::length;
 *  3: to call constructor
 *      BigInteger::new
 *      Integer::new
 *      myclass::new
 *
 *
 *  completable future:
 *  it allows you to perform asynchronous computations
 *
 *  Thread A -> processing a large task ->>>>>>>
 *          thread B ->
 *          thread C
 *          thread D
 *
 *
 *    completable future: default thread pool is fork join pool
 *
 *    consumer: it is a functional interface and takes one parameter and does not return something
 *    supplier it is a functional interface and do return a result, does not take parameter
 *
 *    4 interfaces:
 *      runAsync(runnable)-> you don't need to define type
 *      runAsync(runnable, executor)-> you  don't need to define type
 *      supplyAsync(runnable) -> you need to define type
 *  *   supplyAsync(runnable, executor) -> you need to define type
 *
 *
 *
 */
public class JavaBatchDay3 {


    public static void main(String[] args) {
//        MyFirstFunctionalInteface adder = (a,b) -> a +b;
//        int result = adder.calculate(2,3); // 5
//
//        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        for(int i : list){
//            int x = i * 2;
//            System.out.println(x);
//        }
//        list.forEach(n ->{int x = n * 2;});
//
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
//
//        List<String> strings = Arrays.asList("a1","b1","c1","a3","a2");
//        strings.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
//
//        List<String> strings1 = Arrays.asList("THIS","iS","My","JaVa","STREAM API");
//        List<String> strings2 = strings1.stream().filter(s -> s.chars().anyMatch(Character::isLowerCase)).collect(Collectors.toList());
//        System.out.println(strings2);
//
//        List<String> strings3 = Arrays.asList("THIS123","iS333","My","JaVa22","STREAM API");
//        strings3.stream()
//                .filter(str -> str.matches(".*\\d.*"))
//                .filter(s -> s.chars().anyMatch(Character::isLowerCase))
//                .forEach(System.out::println);
//
//        List<Integer> integerList  = Arrays.asList(1,2,56,6,7,3,8,4,15,45,105);
//        int maxNumber = integerList.stream().reduce(Integer::max).get();
//        System.out.println(maxNumber);
//        System.out.println(integerList);
//        int sum = integerList.stream()
//                .filter(n -> n % 3 == 0 && n % 5 == 0)
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println(sum);
//        boolean anyEven = integerList.stream().anyMatch(n -> n % 2 ==0);
//
//        boolean allEven = integerList.stream().allMatch(n -> n % 2 ==0);
//        if(allEven){
//            System.out.println("yes all even");
//        }else {
//            System.out.println("no ");
//        }
//// group string in this list by length
//        Map<Integer, List<String>> group = strings3.stream().collect(Collectors.groupingBy(String::length));
//
//
//        integerList.stream()
//                .map( n -> {
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("stream api: " + threadName);
//                    return n * n;
//                }).forEach(n -> System.out.println(n));
//
//        integerList.parallelStream()
//                .map( n -> {
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("parallel stream api: " +threadName);
//                    return n * n;
//                }).forEach(n -> System.out.println(n));



        //complatable future

        long startTime = System.currentTimeMillis();
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time:  " +(endTime - startTime));


        // improve way
        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        long startTime1 = System.currentTimeMillis();
        FutureTask<String> task1 = new FutureTask<>(()->{
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "task1";
        });
        threadpool.submit(task1);
        FutureTask<String> task2 = new FutureTask<>(()->{
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "task2";
        });
        threadpool.submit(task2);
        FutureTask<String> task3 = new FutureTask<>(()->{
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return "task3";
        });
        threadpool.submit(task3);
        try{
            task1.get();
            task2.get();
            task3.get();
        }catch (Exception e){
            e.printStackTrace();
        }

        long endtime2 = System.currentTimeMillis();
        System.out.println("time " + (endtime2 - startTime1));
        threadpool.shutdown();
    }
}
