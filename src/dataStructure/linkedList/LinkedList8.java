package dataStructure.linkedList;

/**
 * 두개의 링크드 리스트 교차점 찾기
 */
public class LinkedList8 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(7);
        l1.append(9);
        l1.append(10);
        l1.append(7);
        l1.append(6);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(6);
        l2.append(8);
        l2.append(10);
        l2.append(7);
        l2.append(6);
        l2.retrieve();

        getIntersection(l1.getFirst(), l2.getFirst());


    }

    private static LinkedList.Node getIntersection(LinkedList.Node l1, LinkedList.Node l2){
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if(len1 > len2){
//            l1 = l1.get(len1 - len2);
        }
        return null;
    }

    private static int getListLength(LinkedList.Node node){
        int total = 0;
        while (node != null){
            total++;
            node = node.next;
        }
        return total;
    }
}


