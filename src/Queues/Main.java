package Queues;

public class Main {
    public static void main(String[] args) {
//        ArrayQueue qu = new ArrayQueue(5);
//        qu.enqueue(95);
//        qu.enqueue(75);
//        qu.enqueue(15);
//        qu.enqueue(25);
//        qu.enqueue(445);
//        System.out.println(qu.dequeue());
//        System.out.println(qu.dequeue());
//        qu.enqueue(6);
//        qu.enqueue(67);
//        System.out.println(qu.dequeue());
//        qu.dequeue();
//        qu.enqueue(67);
//        System.out.println(qu.dequeue());
//        System.out.println(qu.dequeue());
//        System.out.println(qu
//        );

//        StackQueue squ = new StackQueue();
//        squ.enqueue(10);
//        System.out.println(squ.dequeue());
//        squ.enqueue(20);
//        squ.enqueue(30);
//        squ.enqueue(40);
//        System.out.println(squ.dequeue());
//        System.out.println(squ.dequeue());
//        squ.enqueue(50);
//        squ.enqueue(60);
//        System.out.println(squ.dequeue());
//        System.out.println(squ.dequeue());
//        System.out.println(squ.dequeue());
//        System.out.println(squ.dequeue());


        PriorityQueue pq = new PriorityQueue(5);
        pq.add(4);
        pq.add(6);
        pq.add(3);
        pq.add(2);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq);
        pq.add(1);
        pq.add(55);
        pq.add(34);
        System.out.println(pq);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq);

    }
}
