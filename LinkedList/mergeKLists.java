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
    public ListNode mergeTwoList(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        if (h1.val <= h2.val) {
            h1.next = mergeTwoList(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeTwoList(h1, h2.next);
            return h2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];

        int mid = (start + end) / 2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return mergeTwoList(left, right);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: create 3 sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Put them in an array
        ListNode[] lists = { l1, l2, l3 };

        // Merge K lists
        Solution sol = new Solution();
        ListNode merged = sol.mergeKLists(lists);

        // Print result
        System.out.println("Merged Linked List:");
        printList(merged);
    }
}
