public class DoubleLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    @Override
    public int at(int index) {
        // Implémentation pour accéder à un élément par son index
        if (index < 0 || index >= this.size) return -1;

        Node current;
        if (index < this.size / 2f) {
            current = this.head;
            for (int i = 0; i < index; i++) current = next(current);
        } else {
            current = this.tail;
            for (int i = size() - 1; i > index; i--) current = prev(current);
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        // Implémentation pour ajouter un élément à la fin de la liste
        Node newNode = new Node(value);

        if (this.tail == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void remove(int index) {
        // Implémentation pour supprimer un élément de la liste
        if (index < 0 || index >= size()) return;

        if (index == 0) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            }
        } else if (index == this.size - 1) {
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            }
        } else {
            Node current;

            if (index < this.size / 2f) {
                current = this.head;
                for (int i = 0; i < index; i++) {
                    current = next(current);
                }
            } else {
                current = this.tail;
                for (int i = size() - 1; i > index; i--) {
                    current = prev(current);
                }
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        this.size--;
    }

    @Override
    public int size() {
        // Implémentation pour obtenir la taille de la liste
        return this.size;
    }

    private Node next(Node node) {
        // Implémentation pour aller au suivant
        System.out.println("Go to next node");
        return node.next;
    }

    private Node prev(Node node) {
        // Implémentation pour aller au précédent
        System.out.println("Go to previous node");
        return node.prev;
    }
}