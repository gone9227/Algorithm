package dataStructure.arraysString;

class ArrayList{

    private Object[] data;
    private int size;
    private int index;

    public ArrayList(){
        this.size = 1;
        this.data = new Object[size];
        this.index = 0;
    }

    void add(Object obj){
        if(this.index == this.size - 1){
            doubling();
        }
        data[this.index] = obj;
        this.index++;
    }

    Object get(int i) throws Exception {
        if(i > this.index - 1){
            throw new Exception("ArrayIndexOutOfBound");
        }else if(i < 0){
            throw new Exception("Negative Value");
        }
        return this.data[i];
    }

    void remove(int i) throws Exception {
        if(i > this.index - 1){
            throw new Exception("ArrayIndexOutOfBound");
        }else if(i < 0){
            throw new Exception("Negative Value");
        }
        for (int j = i; i < this.data.length - 1; i++){
            this.data[j] = this.data[j + 1];
        }
        this.index--;
    }

    void doubling(){
        this.size = this.size * 2;
        Object[] newData = new Object[this.size];
        for(int i = 0; i < data.length; i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
    }



}

public class ArrayListTest {

    public static void main(String[] args) throws Exception {
        ArrayList al = new ArrayList();

        al.add("0");
        al.add("1");
        al.add("2");
        al.add("3");
        al.add("4");
        al.add("5");
        al.add("6");
        al.add("7");
        al.add("8");
        al.add("9");
        al.add("10");

        System.out.println(al.get(5));
        al.remove(5);
        System.out.println(al.get(5));
    }
}
