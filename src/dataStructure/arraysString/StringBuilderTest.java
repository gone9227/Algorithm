package dataStructure.arraysString;

class StringBuilder{

    private int size;
    private char[] data;
    private int index;

    public StringBuilder(){
        this.size = 1;
        this.data = new char[size];
        this.index = 0;
    }

    public void append(String str){
        if(str == null) str = "null";
        int len = str.length();
        ensureCapacity(len);
        for(int i = 0; i < len; i++){
            data[index] = str.charAt(i);
            index++;
        }
    }

    private void ensureCapacity(int len){
        if(len + index > size){
            size = (len + size) * 2;
            char[] newData = new char[size];
            for(int i = 0; i < data.length; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public String toString(){
        return new String(data, 0, index);
    }

}

public class StringBuilderTest {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("Jiji");
        sb.append(" is");
        sb.append(" really smart");
        sb.append(null);
        System.out.println(sb.toString());
    }

}
