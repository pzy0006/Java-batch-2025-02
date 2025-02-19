import java.util.*;

/**
 *what is generic?
 * type safe and allows you put all data type with java collections
 *
 *Upper bounded wildcard -> syntax : ? extends T(Number) -> allows reading and restricts writing
 *Lower bounded wildcard - > ? super T (Number) -> allow you to write and restricts to read
 *
 * Java Collections:
 *
 * 1: arraylist
 *   RandomAccess, this allows you to access and retrieve any random elements at the same speed
 *
 *   the underlaying data structure  is array - > called elementData
 *
 *   modCount; -> concurrent modification exception fail fast
 *
 *   fail safe -> no exception
 *
 *   resizing() -> int newCapacity = oldCapacity + (oldCapacity >> 1); ->
 *   new capacity = old capacity + 0.5 * old capacity = 1.5 old capacity
 *
 *   add                    -> O(1) in the best case. what about worst case? O(N)
 *   add(index,element)        O(N)
 *   get                            always O(1)
 *   remove                         O(N)
 *   indexof                        O(N)
 *   contains                       O(N)
 *
 *
 *  Stack + vector
 *  In java, stack collection extends vector collection
 *  they are first in last out data structure
 *  stack and vector are using synchronization to achieve thread safe
 *
 *  resizing: - >    int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
 *                                          capacityIncrement : oldCapacity);
 *              new capacity = old +       capacityIncrement
 *              new = old * 2
 *
 *  stack
 *  push O(1)
 *  pop  O(1)
 *  peak O(1)
 *  size O(1)
 *
 *   vector:
 *   add O(1)
 *   remove O(1)
 *   size() O(1)
 *
 *
 *   LinkedList + deque:
 *   Doubly-linked list implementation of the List and Deque interfaces.
 *   Implements all optional list operations, and permits all elements (including null).
 *   Note that this implementation is not synchronized
 *
 *  get()           O(n)
 *  add                 O(1)
 *  add(index)          O(n)
 *  remove(index)       O(n)
 *
 *  deque: FIFO (First-In-First-Out)  LIFO (Last-In-First-Out)
 *
 *               3
 *              /\
 *             5 10
 *             /\ /\
 *            7 9 15 11
 *            /
 *          [3,5,10,7,9,15,11,....]
 *
 *        leftNode = parentNode * 2 + 1
 *        rightNode = parentNode * 2 + 2
 *        ParentNode =  (node number -1) /2
 *
 *
 *        you are not allowed to have null value
 *           if (e == null)
 *             throw new NullPointerException();
 *
 *     offer and add -> O(log(n))
 *     deletion O(log(n))
 *     size O(1)
 *     peek O(1)
 *
 *
 *     hashmap
 *
 *     [[1],[2],[3],[4]          [5]] -> table-> array
 *       |            /\          \
 *       1            1 3
 *       \             /\ /\
 *       2'''          /\   /\
 *
 *
 *       in hashmap we are using hashing function to get the index for each element
 *
 *         static final int hash(Object key) {
 *         int h;
 *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *          }
 *     key.hashCode = 1111 1111 1111 1111 1111 0000 1110 1010 = h
 *      (h >>> 16) =  0000 0000 0000 0000 1111 1111 1111 1111
 *  H ^ (h >>> 16) =  1111 1111 1111 1111 0000 1111 0001 0101
 *  (n - 1) & hash =  1111 1111 1111 1111 0000 1111 0001 0101
 *                    0000 0000 0000 0000 0000 0000 0000 1111
 *                    0000 0000 0000 0000 0000 0000 0000 0101 = 5
 *
 *
 * put value :
 * 1: calculating hash value and find the index where we should put
 * 2: if there is null (no hash collision) then hashmap stores it
 * 3: if there exits has collision, hashmap do the following steps:
 *      if hashmap is using red - black tree then call three insertion method and put it
 *      if hash map is using linkedlist then put the value
 *          after inserting, hashmap will check the size of linkedlist,
 *          if the size is greater than 8 then  change linked list to red-black tree
 *  4if there exits duplicate key, then replace the value
 *  5 check the size of table[], if it greater than threshold then resizing
 *
 *
 *  TreeMap -> sorted map -> K.compareTo(key)
 *
 * hashset- unique value in hashset
 *
 * hash set             hashmap                             treeset
 *
 * hash table           linkedlist or red-black tree        red-black tree
 *  O(1)                    O(1)                            O(logn)
 *  not sorted              not sorted                      sorted
 *  yes null                    yes null                        no
 */
public class JavaDay2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);


        Deque<String> deque = new LinkedList<>();

        deque.addFirst("AA");
        deque.addLast("BB");

        String first = deque.removeFirst();
        String last = deque.removeLast();

        deque.addFirst("AA");
        deque.addLast("BB");
        deque.addFirst("CC");
        deque.addLast("DD");

        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            String ele = iterator.next();
            System.out.println(ele);
        }


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }
}

/**
 * T - type
 * E - element
 * k - key
 * v - value
 * @param <T>
 */
class Printer<T>{ // at this class level, it only applies to none static member(data, methods)

    private T myName;
    Printer(T myName){
        this.myName = myName;
    }
    void  print(){
        System.out.println(myName);
    }
    // create a different generic type for static member
    public  static <U> void display(U value){
        System.out.println(value);
    }
    //private static E thisIsMyStaticMember;
}
