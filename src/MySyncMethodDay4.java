import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * synchronized methods:
 * only one thread can access or modify the resource at the same time
 *
 *
 */
public class MySyncMethodDay4 {
    public static void main(String[] args) {
        /**
         * this is example 1:
         * we have only one object and multiple threads
         * as long as one thread is calling synchronized method,  this current object is locked this thread
         * all other threads have to wait the current thread is finished
         * synchronized will locks the current object: this
         *
         *    MySyncMethodDay4 mySyncMethodDay4 = new MySyncMethodDay4();
         *         new Thread(()->{
         *             mySyncMethodDay4.sendEmail();
         *         },"thread1").start();
         *
         *         new Thread(()->{
         *             mySyncMethodDay4.sendSMS();
         *         },"thread2").start();
         */

        /**
         * example 2:
         *  same object, different threads: one is calling sync method, one is calling non - sync method
         *  there is not resources competition
         *  MySyncMethodDay4 mySyncMethodDay4 = new MySyncMethodDay4();
         *         new Thread(()->{
         *             mySyncMethodDay4.sendEmail();
         *         },"thread1").start();
         *
         *         new Thread(()->{
         *             mySyncMethodDay4.externalDevice();
         *         },"thread2").start();
         */


        /**
         * example 3
         *  different object and thread to call two sync methods, there is not resources competition
         *
         * MySyncMethodDay4 mySyncMethodDay4 = new MySyncMethodDay4();
         *         MySyncMethodDay4 methodDay4 = new MySyncMethodDay4();
         *         new Thread(()->{
         *             mySyncMethodDay4.sendEmail();
         *         },"thread1").start();
         *
         *         new Thread(()->{
         *             methodDay4.sendSMS();
         *         },"thread2").start();
         */

        /**
         * example 4:
         * static variable: the locker will lock the class itself
         *    new Thread(()->{MySyncMethodDay4.sendEmail1();},"thread1").start();
         *         new Thread(()->{MySyncMethodDay4.sendSMS1();},"thread2").start();
         *
         *   MySyncMethodDay4 mySyncMethodDay4 = new MySyncMethodDay4();
         *         new Thread(()->{MySyncMethodDay4.sendEmail1();},"thread1").start();
         *         new Thread(()->{mySyncMethodDay4.sendSMS();},"thread2").start();
         */


    }

    public synchronized  void sendEmail(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("sending an email......");
        System.out.println("an email is sent");
    }
    public synchronized void  sendSMS(){
        System.out.println("sending a sms");
        System.out.println("a sms is sent");
    }

    public void externalDevice(){
        System.out.println("connecting external device");
    }

    public static synchronized  void sendEmail1(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("sending an email......");
        System.out.println("an email is sent");
    }
    public static synchronized void  sendSMS1(){
        System.out.println("sending a sms");
        System.out.println("a sms is sent");
    }
}
