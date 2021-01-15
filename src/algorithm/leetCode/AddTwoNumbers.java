package algorithm.leetCode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1, l2;
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (result.next != null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println(result.val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return plusTwoNums(l1, l2, 0);
    }

    private static ListNode plusTwoNums(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        int value = carry;
        if(l1 != null){
            value += l1.val;
        }

        if(l2 != null){
            value += l2.val;
        }

        System.out.println("value = " + value);
        ListNode result = new ListNode(value % 10);

        if(l1 != null || l2 != null){
            result.next = plusTwoNums(l1 == null ? null : l1.next
                                        , l2 == null ? null : l2.next
                                        , value >= 10 ? 1 : 0);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
