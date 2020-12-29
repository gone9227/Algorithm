package dataStructure.queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueWithTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        mq.push(5);
        mq.push(6);
        System.out.println(mq.peek());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove ());
    }

}

class MyQueue<T>{
    Stack<T> stackNewest, stackOldest;

    public MyQueue(){
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void push(T data){
        stackNewest.push(data);
    }

    public void shiftData(){
        if(stackOldest.isEmpty()){
            while (!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftData();
        return stackOldest.peek();
    }

    public T remove(){
        shiftData();
        return stackOldest.pop();
    }
}

