public class SingleLinkedList implements LinkedList {
    private Node head;
    private int size;

    private class Node {
        int value; // Valeur du noeud
        Node next; // Noeud suivant

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public SingleLinkedList() { // Constructeur
        this.head = null;
        this.size = 0;
    }

    @Override
    public int at(int index) {
        if (index < 0 || index >= size()) return -1;

        // Je crée un noeud courant
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = next(current); // Je passe au noeud suivant
        }
        return current.value;
    }

    @Override
    public void add(int value) {
        // Implémentation pour ajouter un élément à la fin de la liste
        Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
        } else {
            Node current = this.head;

            while(current.next != null) {
                current = next(current);
            }
            current.next = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        // Implémentation pour supprimer un élément de la liste
        if (index < 0 || index >= size()) return;

        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = next(current);
            }
            current.next = next(current.next);
        }
        size--;
    }

    @Override
    public int size() {
        // implémentation pour obtenir la taille de la liste
        return this.size;
    }

    private Node next(Node node) {
        // Affiche un message pour indiquer que l'on passe au noeud suivant
        System.out.println("Go to next node");
        return node.next;
    }

    public static void main(String[] args) {
        LinkedList list = new SingleLinkedList();

        // Add elements to the list
        list.add(1);
        list.add(2);
        list.add(3);

        // Access elements by index
        System.out.println("Element at index 0: " + list.at(0)); // Expected output: 1
        System.out.println("Element at index 1: " + list.at(1)); // Expected output: 2
        System.out.println("Element at index 2: " + list.at(2)); // Expected output: 3

        // Remove an element by index
        list.remove(1);
        System.out.println("Element at index 1 after removal: " + list.at(1)); // Expected output: 3
    }
}