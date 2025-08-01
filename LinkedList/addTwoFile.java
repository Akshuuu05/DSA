import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Sample test case
    public static void main(String[] args) {
        Solution sol = new Solution();

        // List 1: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // List 2: 5 -> 6 -> 4 (represents 465)
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = sol.addTwoNumbers(l1, l2); // Should return 7 -> 0 -> 8 (represents 807)

        System.out.print("Sum: ");
        printList(result);
    }
}
