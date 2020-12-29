package dataStructure.stack;

public class StackSort {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        sort(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

    private static void sort(Stack<Integer> s1){
        Stack<Integer> s2 = new Stack<>();
        while (!s1.isEmpty()){
            int tmp = s1.pop();
            while (!s2.isEmpty() && s2.peek() > tmp){
                s1.push(s2.pop());
            }
            s2.push(tmp);
        }

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }

    }

}


