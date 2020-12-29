package dataStructure.linkedList;

/**
 * 두개의 링크드 리스트로 이루어진 숫자 더하기(순방향)
 */
public class LinkedList7 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append('m');
        l1.append('a');
        l1.append('d');
        l1.append('a');
        l1.append('e');
        l1.retrieve();

        boolean result = isPalindrome(l1.getFirst());
        System.out.println(result);


    }

    private static boolean isPalindrome(LinkedList.Node head){
        LinkedList.Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static boolean isEqual(LinkedList.Node head, LinkedList.Node reversed) {
        while (head != null && reversed != null){
            if(head.data != reversed.data){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return head == null && reversed == null;
    }

    private static LinkedList.Node reverseAndClone(LinkedList.Node head) {
        LinkedList.Node node = null;

        while (head != null){
            LinkedList.Node n = new LinkedList.Node(head.data);
            n.next = node;
            node = n;
            head = head.next;
        }
        return node;
    }


}


