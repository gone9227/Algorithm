package dataStructure.stack;

public class Stack5 {
    public static void main(String[] args) {
        StackWithMin2 sm = new StackWithMin2();
        sm.push(3);
        sm.push(4);
        sm.push(1);
        sm.push(2);
        sm.push(5);
        System.out.println(sm.min());
        sm.pop();
        sm.pop();
        sm.pop();
        System.out.println(sm.min());
    }
}

class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s2;
    public StackWithMin2(){
        s2 = new Stack<Integer>();
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
            return s2.peek();
        }
    }

    public void push(int value){
        if(min() > value){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        Integer popValue = super.pop();
        if(popValue.equals(min())){
            s2.pop();
        }
        return popValue;
    }
}
