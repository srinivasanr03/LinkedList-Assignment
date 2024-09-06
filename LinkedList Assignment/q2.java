class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to insert a node after the given node
    void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null.");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Method to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class q2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(4); // Let's assume we want to insert after this node
        ll.head.next = second;
        second.next = third;

        System.out.println("Original linked list:");
        ll.printList();

        int newData = 3;
        ll.insertAfter(third, newData);

        System.out.println("Linked list after inserting " + newData + " after node with value 4:");
        ll.printList();
    }
}
