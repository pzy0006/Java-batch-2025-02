import sun.net.util.IPAddressUtil;

/**
 * Day1
 * what is oop?
 * object oriented programming
 * what is an object?
 *  state: fundamental elements: for example: your bank account has current balance, name, address..
 *  behaviors: think about a function in an obaject. like your bank can do deposits, withdrawals and change your name, adress
 *
 *  polymorphism:  a same method can be performed in a different way
 *      in java we call overloading and overriding:
 *      overloading: you have same method name but you have different variables: number of variables and types variabels
 *      overriding: it happens between parent class and child class. you cann't change method name and variable at all.
 *
 *   class people{
 *       private int age; <--- can we overriding data member? no
 *
 *   }
 *
 *   encapsulation:  means it protects and manages its own info
 *      in java, we can use privaite access modifier and getter and setter
 *
 *
 *   interface vs abstract class: see below
 *
 *   does java support multiple inheritance?
 *   the diamond problem: this problem occurs when two superclasses have a common base class, and
 *   subclass inherits from both these superclasses.
 *          class A
 *     classB     class c
 *
 *          class D
 *
 *
 *   inheritance:
 *      classes can be created from other classes by using inheritance.
 *      code reusability
 *
 *   primitive vs wrapper type:
 *    don't use "==", use equals()
 *    wrapper type like integer,  Byte Long and Short range is [-128, 127]
 *
 *      public static Integer valueOf(int i) {
 *         if (i >= IntegerCache.low && i <= IntegerCache.high)
 *             return IntegerCache.cache[i + (-IntegerCache.low)];
 *         return new Integer(i);
 *     }
 *
 *     String vs StringBuilder vs StringBuffer
 *     in the String class: java use this:  private final char value[]; so it is immutbale class
 *  StringBuilder  is not immutable class, not thread safe
 *  StringBuffer is thread safe
 *
 *          class           package             subclass        world
 *  public     Y                Y                   Y               Y
 *  protected Y                 Y                   Y               N
 *  default  Y                  Y                    N              N
 *  private Y                   N                   N               N
 *
 *  This vs Super keywords
 *
 // "This" keyword can be used to reference current object
 *  this keyword can be used as parameter  or as a constructor parameter
 *can we return "this" keyword? YES
 *
 * super keyword:
 * points to our parent object
 * call parent's constructor
 * call parent's functions
 *
 * does java use pass-by-value or pass-by-reference?
 * java use pass-by-value
 * for an object, java will pass the value of object, like 0X12345678 to your function or somewhere else.
 *
 *
 *
 * shallow copy and deep copy
 *both original and copied object point to the same address -> shallow copy
 * original and copied object point to the different addresses -> deep copy
 *
 *
 * exception:
 * checked exception and unchecked exception
 * checked: it happens in compile time. throws, throw you can use try catch finally block
 * unchecked exception: it happens in runtime,
 *
 * final vs finally vs finalize
 *
 *
 * static and non static
 *   JavaDay1.staticMethod(), staticVariable
 *   static ketword can be used wit method/function, variable, block.
 *   it means that member belongs to class itself, not an object.
 *   non-static members belongs to an object and can not be accessed within static class/ method.
 *
 *
 *error vs exception:
 * error is "bad" things that  is unrecoverable
 * exception is some thing you can recover from it.
 *
 *
 *
 *
 */
public class JavaDay1 {
    public static void main(String[] args) {
        Integer i1 = 12;// -> Ox12345678
        Integer i2 = 12;// -> Ox12345678
        System.out.println(i1 == i2);// true; under the range
        Integer i3 = 333; // ->Ox12345672
        Integer i4 = 333; // ->Ox12345623
        System.out.println(i3 == i4);// false, out of the range
        System.out.println(i3.equals(i4)); // true;

        String str1 = "first name";
        String str2 = "last name";
        String fullName = str1 + str2; // StringBuilder(str1) + StringBuilder(str2) => change back to String
        Student student1 = new Student("Matthew", 18);
        student1.out();
        ThisAsParam thisAsParam = new ThisAsParam();
        System.out.println(thisAsParam);
        thisAsParam.method2();
    }

}

abstract class myabstractclass{
    String myName =""; // it is just public, NOT A STATIC AND FINAL
    //can we have constructor here -> YES
    public myabstractclass(String myName){
        this.myName = myName;
    }

    void thisIsMethod(){
        System.out.println("this is a method with body in abstract class");
    }
    // can we have abstract method in an abstract class? YES
    abstract void thisAbtractMethod();
}

interface myInterfaceClass{
    public static  final String myName =""; // default modifer is public, static and final
//    //can we have constructor here -> No
//    public myInterfaceClass(String myName){ -- not allowed
//
//    }

    void thisIsMethod(); // this is abstract method, you cann't have method body
    default void thisIsMyMethodWithBody(){
        System.out.println("I have method body in an interface class");
    }

    //static method? YES, but only after java 8
    static int add(int a, int b){
        return  a + b;
    }
    // can we have private method? YES, but only after java 9
//    private int multiply(int a, int b){
//        return a *b;
//    }
}


// "This" keyword can be used to reference current object
class Student{
    private String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    void  out(){
        System.out.println(name + " "  + age);
    }
    //this keyword to call constructor
    public Student(){
        System.out.println("call constractor");
    }
    public Student(String name){
        this();
        this.name = name;
    }
}

// this keyword can be used as parameter  or as a constructor parameter
class ThisAsParam{
    void method1(ThisAsParam thisAsParam){
        System.out.println(thisAsParam);
    }
    void method2(){
        method1(this);
    }

}

// cam we return "this" keyword? YES
class ReturnThis{
    ReturnThis getThisReturnResult(){
        return this;
    }
}

class Animal{
    int age;
    public Animal(){
        System.out.println("parent cons");
    }
    void eat(){
        System.out.println("Animal is eating");
    }
}

class Dog extends  Animal{
    public  Dog(){
        super();// call parent constructor
    }
    public  Dog(int age){
        super.age = age;
    }
    @Override
    void eat(){
        super.eat();// call parent method/ function
        System.out.println("your dog is eating");
    }
}