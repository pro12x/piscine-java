public class CircularLinkedList implements LinkedList {
    private Node head; // La tête de la liste
    private int size; // La taille de la liste

    private static class Node { // La classe Noeud
        int value; // La valeur du noeud
        Node next; // Le noeud suivant

        Node(int value) { // Le constructeur de la classe Noeud
            this.value = value;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int at(int index) {
        if (index < 0 || isEmptyList()) return -1;

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = next(current);
        }

        return current.value;
    }

    @Override
    public void add(int value) {
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
            this.head.next = this.head;
        } else {
            Node current = this.head;

            while(current.next != this.head) {
                current = next(current);
            }
            current.next = node;
            node.next = this.head;
        }
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || isEmptyList()) return;

        if (index == 0) {
            Node current = this.head;
            while (current.next != this.head) {
                current = next(current);
            }
            this.head = next(this.head);
            current.next = this.head;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = next(current);
            }
            current.next = next(current.next);
        }
        this.size--;
    }

    @Override
    public int size() {
        return size;
    }

    private Node next(Node node) {
        System.out.println("Go to next node");
        return node.next;
    }

    private boolean isEmptyList() {
        return this.head == null;
    }
}
