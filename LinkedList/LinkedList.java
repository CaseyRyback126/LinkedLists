public class LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original list:");
        list.printList();

        System.out.println("Reversed list:");
        list.revert();
        list.printList();
    }
    private Node head;

    private static class Node {
        private int value;
        private Node next;
    }

    public void addFirst(int value) {
        Node first = new Node();
        first.value = value;
        if (head != null) {
            first.next = head;
        }
        head = first;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean ifFind(int value) {
        Node i = head;
        while (i != null) {
            if (i.value == value) {
                return true;
            }
            i = i.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node last = new Node();
        last.value = value;
        if (head == null) {
            head = last;
        } else {
            Node i = head;
            while (i.next != null) {
                i = i.next;
            }
            i.next = last;
        }
    }

    public void deleteLast(int value) {
        if (head != null) {
            Node i = head;
            while (i.next != null) {
                if (i.next.next != null) {
                    i.next = null;
                }
            }
            head = null;
        }
    }

    public void revert() {
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}
