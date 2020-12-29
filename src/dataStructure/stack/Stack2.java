package dataStructure.stack;

import java.util.EmptyStackException;

/**
 * Array 하나로 스택 3개 구현하기
 */
public class Stack2 {

    public static void main(String[] args) throws FullStackException {
        FixedMultiStacks ms = new FixedMultiStacks(3);
        ms.push(0,1);
        ms.push(0,2);
        ms.push(0,3);
        System.out.println(ms.isFull(0));
        System.out.println(ms.isEmpty(0));
        System.out.println(ms.pop(0));
        System.out.println(ms.pop(0));
        System.out.println(ms.pop(0));
        System.out.println(ms.isFull(0));
        ms.push(1,1);
        ms.push(1,2);
        ms.push(1,3);
        try {
            System.out.println(ms.pop(1));
            System.out.println(ms.pop(2));
        }catch (EmptyStackException e){
            System.out.println("Empty");
        }

        System.out.println(ms.isEmpty(1));
        System.out.println(ms.isFull(2));
        try {
            ms.push(2, 4);
            ms.push(2, 5);
            ms.push(2, 6);
            ms.push(2, 7);
        }catch (FullStackException e){
            System.out.println("Full");
        }
        System.out.println(ms.peek(2));

    }

}

class FullStackException extends Exception{
    public FullStackException(){
        super();
    }

    public FullStackException(String msg){
        super(msg);
    }
}

class FixedMultiStacks{
    private int numOfStacks = 3;
    private int stackSize;
    private int[] values;
    private int[] size;

    public FixedMultiStacks(int stackSize){
        this.stackSize = stackSize;
        this.values = new int[stackSize * numOfStacks];
        this.size = new int[stackSize];
    }

    public boolean isEmpty(int stackNum){
        return size[stackNum] == 0;
    }

    public boolean isFull(int stackNum){
        return size[stackNum] == stackSize;
    }

    public int getTopIndex(int stackNum){
        return stackNum * stackSize + size[stackNum] - 1;
    }

    public void push(int stackNum, int data) throws FullStackException {
        if(isFull(stackNum)){
            throw new FullStackException();
        }
        values[getTopIndex(stackNum) + 1] = data;
        size[stackNum]++;
    }

    public int pop(int stackNum) throws EmptyStackException {
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        int top = getTopIndex(stackNum);
        int item = values[top];
        values[top] = 0;
        size[stackNum]--;
        return item;
    }

    public int peek(int stackNum){
        if(isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[getTopIndex(stackNum)];
    }
}
