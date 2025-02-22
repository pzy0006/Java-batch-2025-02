import java.sql.Time;
import java.util.concurrent.*;

/**
 * get() vs join()
 *
 *    public T get() throws InterruptedException, ExecutionException {
 *         Object r;
 *         return reportGet((r = result) == null ? waitingGet(true) : r);
 *     }
 *
 *     public T join() {
 *         Object r;
 *         return reportJoin((r = result) == null ? waitingGet(false) : r);
 *     }
 *
 *      public T getNow(T valueIfAbsent) { you need an immediate fallback
 *         Object r;
 *         return ((r = result) == null) ? valueIfAbsent : reportJoin(r);
 *     }
 *
 *
 *     thenRun vs thenApply vs thenAccept
 *     thenApply: has return, task B depends on task A
 *     thenRun:  to do task B regardless task A computation result;
 *     thenAccept: to do task B when task is finised, and task B needs result of task A
 *
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()); // hello world for completable future
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        });
//        System.out.println(completableFuture.get());// join()
//
//
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
//            System.out.println(Thread.currentThread().getName()); // hello world for completable future
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        },executorService);
//        System.out.println(completableFuture.get());// join()
//        executorService.shutdown();
//
//        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName()); // hello world for completable future
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return "hello";
//        });
//        System.out.println(completableFuture2.get());
//
//        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName()); // hello world for completable future
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return "hello";
//        });
//
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(completableFuture3.complete("# 3 is finished"));
//
//        CompletableFuture<Integer> completableFuture4 = CompletableFuture.supplyAsync(()->{
//            // task A
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("step 1: good to go");
//            return 1;
//        }).thenApply( result ->{
//            //task B
//            System.out.println("step 2: good to go");
//            return result + 2;
//        }).thenApply(result ->{
//            //task c
//            System.out.println("step 2: good to go");
//            return result + 3;
//        });
//        System.out.println("final resule: " + completableFuture4.join());

//        CompletableFuture<Void> completableFuture5  = CompletableFuture.supplyAsync(()->{
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("task A is doing somehting");
//            return "task A result";
//        }).thenRun(()->{
//            System.out.println("doing task B with thenRun");
//        });
//        System.out.println("thenRun result: " + completableFuture5.join());
//
//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->{
//            try{
//                TimeUnit.SECONDS.sleep(2);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("task A: fetchind data");
//            return "Task A result";
//        }).thenAccept(result->{
//            System.out.println(" task 2 printing result of task A" + result);
//        });
//        System.out.println("final result: " + future.join());


//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//            //task A
//            int i = 10;
//            if(i > 3){
//                int a = i / 0;
//            }
//            return "false";
//        }).whenComplete((result,e) ->{
//            if(e == null){
//                System.out.println("task A is result is " + result);
//            }
//        }).exceptionally(e->{
//            e.printStackTrace();
//            System.out.println("hi, we are having exception here");
//            return null;
//        });
//        System.out.println(completableFuture.join());


//        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->{
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return 10;
//        });
//        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return 10;
//        });
//        CompletableFuture res  = completableFuture1.thenCombine(completableFuture2,(x,y) ->{
//            System.out.println(x);
//            System.out.println(y);
//            return x + y;
//        });
//        System.out.println(res.join());


        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "task A result";
        });
        CompletableFuture<String> completableFuture1 = completableFuture2.thenCompose(result ->{
            return CompletableFuture.supplyAsync(()->{
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return "task B is finished";
            });

        });
        ///

    }




}
