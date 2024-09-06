class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class q4 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty list or a list with a single node is considered a palindrome
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare the first half with the reversed second half
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false; // Not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true; // Palindrome
    }

    // Method to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        // Check if it is a palindrome
        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
