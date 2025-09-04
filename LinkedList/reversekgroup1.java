class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        int cnt = 0;

        // Count k nodes ahead
        while (cnt < k && temp != null) {
            temp = temp.next;
            cnt++;
        }

        // If less than k nodes found, reverse them as well
        if (cnt < k) {
            temp = head;
            Node prevNode = null;
            while (cnt-- > 0) {
                Node next = temp.next;
                temp.next = prevNode;
                prevNode = temp;
                temp = next;
            }
            return prevNode;
        }

        // Otherwise, reverse first k nodes and recurse
        Node prevNode = reverseKGroup(temp, k);
        temp = head;
        int count = 0;

        while (count < k) {
            Node next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            count++;
        }

        return prevNode;
    }

    // Utility to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2; // group size

        Solution sol = new Solution();
        System.out.print("Original List: ");
        printList(head);

        head = sol.reverseKGroup(head, k);

        System.out.print("Reversed in groups of " + k + ": ");
        printList(head);
    }
}
