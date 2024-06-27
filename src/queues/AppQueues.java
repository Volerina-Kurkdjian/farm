package queues;

import java.util.*;

public class AppQueues {

    public static void main(String[] args) {

        Queue<String> queue=new LinkedList<>();
        queue.add("Adam");
        queue.add("Ana");
        queue.add("Amanda");
        queue.add("Corina");
        queue.add("Adam");

        Queue<Person> personQueue=new PriorityQueue<>();
        personQueue.add(new Person("Adelinne",32));
        personQueue.add(new Person("Joe",23));
        personQueue.add(new Person("Bannana",33));
        personQueue.add(new Person("Hannana",43));
        personQueue.add(new Person("Mark",30));
        personQueue.add(new Person("Emilly",23));

        while(personQueue.peek()!=null){
            System.out.println(personQueue.poll());
        }


        Deque<Integer> deque=new ArrayDeque<>();
        deque.add(1);
        deque.add(11);
        deque.add(111);
        deque.add(11111);
        while(!deque.isEmpty()){
            System.out.println(deque.poll());
        }



    }
}
