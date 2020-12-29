package dataStructure.queue;

import java.util.NoSuchElementException;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }

}

class Queue<T>{
    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T data){
        Node<T> t = new Node<T>(data);
        if(tail != null){
            tail.next = t;
        }
        tail = t;
        if(head == null){
            head = tail;
        }
    }

    public T remove(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T item = head.data;
        head = head.next;

        if(head == null){
            tail = null;
        }
        return item;
    }

    public T peek(){
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
