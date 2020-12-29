package dataStructure.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class SetOfStacks2 {

    public static void main(String[] args) {
        SetOfStack2 sos = new SetOfStack2(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        sos.push(7);
        sos.push(8);
        System.out.println(sos.popAt(1));
        System.out.println(sos.popAt(0));
        System.out.println(sos.popAt(1));
    }
}

class StackWithIndex<E>{
    class Node{
        E data;
        Node above;
        Node below;
        public Node(E data){
            this.data = data;
        }
    }

    int capacity;
    int size;
    Node top;
    Node bottom;
    public StackWithIndex(int capacity){
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    public void push(E data) throws FullStackException {
        if(isFull()) throw new FullStackException();

        Node n = new Node(data);
        push(n);
    }

    public void push(Node n) throws FullStackException {
        if(isFull()) throw new FullStackException();

        if(isEmpty()){
            top = n;
            bottom = n;
        }else {
            top.above = n;
            n.below = top;
            top = n;
        }
        size++;
    }

    public E pop(){
        if(isEmpty()) throw new EmptyStackException();

        E data = top.data;
        top = top.below;
        if(top == null){
            bottom = null;
        }else {
            top.above = null;
        }
        size--;
        return data;
    }

    public Node popBottom(){
        if(isEmpty()) throw new EmptyStackException();

        Node n = bottom;
        bottom = bottom.above;
        if(bottom == null){
            top = null;
        }else {
            bottom.below = null;
        }
        size--;
        return n;
    }
}

class SetOfStack2{
    int capacity;
    ArrayList<StackWithIndex<Integer>> stacks = new ArrayList<StackWithIndex<Integer>>();

    public SetOfStack2(int capacity){
        this.capacity = capacity;
    }

    public void addStack(){
        stacks.add(new StackWithIndex<Integer>(capacity));
    }

    public void removeLastStack(){
        stacks.remove(stacks.size() - 1);
    }

    public StackWithIndex<Integer> getLastStack(){
        if(stacks.size() == 0) return null;

        return stacks.get(stacks.size() - 1);
    }

    public void push(int data) {
        StackWithIndex<Integer> last = getLastStack();
        if(last == null || last.isFull()){
            addStack();
            last = getLastStack();
        }
        try{ last.push(data); } catch (FullStackException e){}
    }

    public int pop(){
        StackWithIndex<Integer> last = getLastStack();
        if(last == null || last.isEmpty()){
            throw new EmptyStackException();
        }
        int data = last.pop();
        if(last.isEmpty()){
            removeLastStack();
        }
        return data;
    }

    public int popAt(int index){
        if(stacks.size() <= 0){
            throw new EmptyStackException();
        }
        if(index < 0 || index >= stacks.size()){
            throw new IndexOutOfBoundsException();
        }
        StackWithIndex<Integer> stack = stacks.get(index);
        if(stack == null || stack.isEmpty()){
            throw new EmptyStackException();
        }
        int data = stack.pop();
        shiftLeft(index);
        return data;
    }

    public void shiftLeft(int index){
        if(index < stacks.size() - 1){
            StackWithIndex<Integer> right = stacks.get(index + 1);
            StackWithIndex<Integer> left = stacks.get(index);
            try{
                left.push(right.popBottom());
            }catch (FullStackException e){}

            if(right.isEmpty()){
                stacks.remove(index + 1);
            }
            shiftLeft(index + 1);
        }
    }

}
