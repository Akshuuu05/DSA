public class ListNode {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;

        while (cnt < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            cnt++;
        }
        ListNode preNode = reverseKGroup(temp, k);

        temp = head;
        cnt = 0;

        while (cnt < k) {
            ListNode next = temp.next;
            temp.next = preNode;
            preNode = temp;
            temp = next;
            cnt++;
        }

        return preNode;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2; // group size

        Solution sol = new Solution();
        System.out.print("Original List: ");
        printList(head);

        head = sol.reverseKGroup(head, k);

        System.out.print("Reversed in groups of " + k + ": ");
        printList(head);
    }

}
