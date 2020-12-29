package dataStructure.stack;

public class Stack4 {

    public static void main(String[] args) {
        StackWithMin sm = new StackWithMin();
        sm.push(3);
        sm.push(5);
        sm.push(2);
        sm.push(1);
        sm.push(4);
        System.out.println(sm.min());
        sm.pop();
        sm.pop();
        System.out.println(sm.min());
    }

}

class NodeWithMin{
    int value;
    int min;

    public NodeWithMin(int v, int min){
        this.value = v;
        this.min = min;
    }
}

class StackWithMin extends Stack<NodeWithMin>{

    public int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;
        }else {
            return peek().min;
        }
    }

    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

}
