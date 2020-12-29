package dataStructure.stack;

import java.util.EmptyStackException;

/**
 * 유동배열 스택
 */
public class Stack3 {

    public static void main(String[] args) {
        MultiStacks ms = new MultiStacks(3, 5);

        try {
            ms.push(0, 1);
            ms.push(0, 2);
            ms.push(0, 3);
            ms.push(1, 1);
            ms.push(1, 2);
            ms.push(1, 3);
            ms.push(2, 1);
            ms.push(2, 2);
            ms.push(2, 3);
            ms.push(2, 4);
            ms.push(2, 5);
            ms.push(2, 6);
            ms.push(2, 7);
        }catch (FullStackException e){
            System.out.println("FULL");
        }

        try {
            System.out.println(ms.allStacksAreFull());
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(0));
            System.out.println(ms.pop(1));
            System.out.println(ms.pop(2));
            System.out.println(ms.peek(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
            System.out.println(ms.pop(2));
        }catch (EmptyStackException e){
            System.out.println("EMPTY");
        }
    }
}

class MultiStacks{
    private class StackInfo{
        public int start, dataSize, stackSize;
        public StackInfo(int start, int stackSize){
            this.start = start;
            this.stackSize = stackSize;
            this.dataSize = 0;
        }

        public boolean isWithinStack(int index){
            if(index < 0 || index > values.length){
                return false;
            }
            int virtualIndex = index < start ? index + values.length : index;
            int end = start + stackSize;
            return start <= virtualIndex && virtualIndex < end;
        }

        public int getLastStackIndex(){
            return adjustIndex(start + stackSize - 1);
        }
        public int getLastDataIndex(){
            return adjustIndex(start + dataSize - 1);
        }
        public int getNewDataIndex(){
            return adjustIndex(getLastDataIndex() + 1);
        }
        public boolean isFull(){
            return dataSize == stackSize;
        }
        public boolean isEmpty(){
            return dataSize == 0;
        }
    }

    private StackInfo[] info;
    private int[] values;

    public MultiStacks(int numOfStacks, int defaultSize){
        info = new StackInfo[numOfStacks];
        for(int i = 0; i < numOfStacks; i++){
            info[i] = new StackInfo(i * defaultSize, defaultSize);
        }
        values = new int[numOfStacks * defaultSize];
    }

    private void expand(int stackNum){
        int nextStack = (stackNum + 1) % info.length;
        shift(nextStack);
        info[stackNum].stackSize++;
    }

    private void shift(int stackNum){
        StackInfo stack = info[stackNum];
        if(stack.dataSize >= stack.stackSize){
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.stackSize++;
        }
        int index = stack.getLastStackIndex();
        while (stack.isWithinStack(index)){
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        values[stack.start] = 0;
        stack.start = nextIndex(stack.start);
        stack.stackSize--;
    }

    public int numberOfElements(){
        int totalDataSize = 0;
        for (StackInfo si : info) {
            totalDataSize += si.dataSize;
        }
        return totalDataSize;
    }

    public boolean allStacksAreFull(){
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index){
        int max = values.length;
        return ((index % max) + max ) % max;
    }

    private int nextIndex(int index){
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index){
        return adjustIndex(index - 1);
    }

    public void push(int stackNum, int data) throws FullStackException{
        if(allStacksAreFull()){
            throw new FullStackException();
        }

        StackInfo stack = info[stackNum];
        if(stack.isFull()){
            expand(stackNum);
        }
        values[stack.getNewDataIndex()] = data;
        stack.dataSize++;
    }

    public int pop(int stackNum){
        StackInfo stack = info[stackNum];

        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        int data = values[stack.getLastDataIndex()];
        values[stack.getLastStackIndex()] = 0;
        stack.dataSize--;
        return data;
    }

    public int peek(int stackNum){
        StackInfo stack = info[stackNum];
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return values[stack.getLastDataIndex()];

    }
}
