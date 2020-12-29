package dataStructure.arraysString;

import java.util.LinkedList;

class HashTable{
    class Node{
        String key;
        String value;
        public Node(String key, String value){
            this.key = key;
            this.value = value;
        }
        String value(){
            return value;
        }
        void value(String value){
            this.value = value;
        }
    }

    LinkedList<Node>[] data;
    HashTable(int size){
        this.data = new LinkedList[size];
    }

    int getHashCode(String key){
        int hashCode = 0;
        for(char c : key.toCharArray()){
            hashCode += c;
        }
        return hashCode;
    }

    int convertToIndex(int hashCode){
        return hashCode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    void put(String key, String value){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        if(list == null){
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if(node == null){
            list.addLast(new Node(key, value));
        }else {
            node.value(value);
        }
    }

    String get(String key){
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not Found" : node.value();
    }

}


public class HashTableTest {

    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung", "She is pretty");
        h.put("jiji", "She is gorgeous");
        h.put("haha", "She is funny");
        h.put("yoyo", "She is cute");
        h.put("jiji", "She is very nice");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jiji"));
        System.out.println(h.get("haha"));
        System.out.println(h.get("yoyo"));

    }
}


