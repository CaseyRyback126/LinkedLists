public class LinkedListTwoSide {
    public static void main(String[] args) {
        LinkedListTwoSide list = new LinkedListTwoSide();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);

        System.out.println("Original list:");
        list.printList();

        System.out.println("Reversed list:");
        list.reverse();
        list.printList();
    }

    private Node head;
    private Node tail;

    private static class Node {
        private Node next;
        private Node previous;
        private int value;

    }

    public void addFirst(int value) {
        Node first = new Node();
        first.value = value;
        if (head != null) {
            first.next = head;
            head.previous = first;
        } else {
            tail = first;
        }
        head = first;
    }

    public void deleteFirst() {
        if (head != null && head.next != null) {
            head = head.next;
            head.previous = null;
        } else {
            head = null;
            tail = null;
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
        if (tail == null) {
            head = last;
        } else {
            last.previous = tail;
            tail.next = last;
        }
        tail = last;
    }

    public void deleteLast(int value) {
        if (head != null && head.next != null) {
            tail = tail.previous;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    }

    public void bubbleSort() {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            Node i = head;
            while (i != null && i.next != null) {
                if (i.value > i.next.value) {
                    int temp = i.value;
                    i.value = i.next.value;
                    i.next.value = temp;
                    needSort = true;
                }
                i = i.next;
            }
        }
    }

    public void reverse() {
        Node current = head;
        Node temp;

        while (current != null) {
            // меняем указатель next и previous для текущего элемента
            temp = current.next;
            current.next = current.previous;
            current.previous = temp;
            // продвигаемся к следующему элементу
            current = temp;
        }
        // меняем указатели head и tail
        temp = head;
        head = tail;
        tail = temp;
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
