class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            // If current node value is equal to next node value, skip the next node
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}

public class q3 {
    public static void main(String[] args) {
        // Create a sorted linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        // Call the deleteDuplicates method
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);

        // Print the result
        printList(result);
    }

    // Method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
