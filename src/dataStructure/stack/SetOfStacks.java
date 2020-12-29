package dataStructure.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {

    public static void main(String[] args) {
        SetOfStack sos = new SetOfStack(3);
        sos.push(1);
        sos.push(2);
        sos.push(3);
        sos.push(4);
        sos.push(5);
        sos.push(6);
        sos.push(7);
        sos.push(8);
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }


}

class SetOfStack{
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
    int capacity;

    SetOfStack(int capacity){
        this.capacity = capacity;
    }

    public Stack<Integer> getLastStack(){
        if(stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void addStack(){
        stacks.add(new Stack<Integer>());
    }

    public void removeStack(){
        stacks.remove(stacks.size() - 1);
    }

    public void push(int data){
        Stack<Integer> last = getLastStack();
        if(last == null || last.size() == capacity){
            addStack();
            last = getLastStack();
        }
        last.push(data);
    }

    public int pop(){
        Stack<Integer> last = getLastStack();
        if(last == null || last.isEmpty()){
            throw new EmptyStackException();
        }
        int value = last.pop();
        if(last.isEmpty()){
            removeStack();
        }
        return value;
    }
}
