package dataStructure.linkedList;

/**
 * 두개의 링크드 리스트로 이루어진 숫자 더하기(순방향)
 */
public class LinkedList6 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(1);
//        l1.append(4);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(1);
        l2.append(1);
//        l2.append(3);
        l2.retrieve();

        LinkedList.Node result = sumLists(l1.getFirst(), l2.getFirst());
        while (result.next != null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println(result.data);
    }

    private static LinkedList.Node sumLists(LinkedList.Node l1, LinkedList.Node l2){
        int len1 = getListLen(l1);
        int len2 = getListLen(l2);

        if(len1 < len2){
            l1 = lpadList(l1, len2 - len1);
        }else if(len1 > len2) {
            l2 = lpadList(l2, len1 - len2);
        }

        Storage storage = addLists(l1, l2);
        if(storage.carry != 0){
            storage.result = insertBefore(storage.result, storage.carry);
        }
        return storage.result;

    }

    private static Storage addLists(LinkedList.Node l1, LinkedList.Node l2) {
        if(l1 == null && l2 == null){
            Storage storage = new Storage();
            return storage;
        }

        Storage storage = addLists(l1.next, l2.next);
        int value = storage.carry + l1.data + l2.data;
        int data = value % 10;
        storage.result = insertBefore(storage.result, data);
        storage.carry = value / 10;

        return storage;
    }

    private static int getListLen(LinkedList.Node l){
        int total = 0;
        while (l != null){
            total++;
            l = l.next;
        }
        return total;
    }

    private static LinkedList.Node insertBefore(LinkedList.Node node, int data){
        LinkedList.Node before = new LinkedList.Node(data);
        if(node != null){
            before.next = node;
        }
        return before;
    }

    private static LinkedList.Node lpadList(LinkedList.Node node, int length){
        LinkedList.Node head = node;
        for(int i = 0; i < length; i++){
            head = insertBefore(head, 0);
        }
        return head;
    }

}

class Storage{
    int carry = 0;
    LinkedList.Node result = null;
}

