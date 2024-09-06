class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class q5 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(2);

        q5 solution = new q5();
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        System.out.println("Resultant list for Example 1:");
        solution.printList(result1);

        // Example 2
        ListNode l3 = new ListNode(7);
        l3.next = new ListNode(5);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(6);

        ListNode l4 = new ListNode(8);
        l4.next = new ListNode(4);

        ListNode result2 = solution.addTwoNumbers(l3, l4);
        System.out.println("Resultant list for Example 2:");
        solution.printList(result2);
    }
}
