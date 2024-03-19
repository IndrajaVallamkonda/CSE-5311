public interface LinkedListInterface {
    void insert(int data);
    void delete(int data);
    void display();
    Node search(int data);
}

class Node {
    int data;
    Node next;

    public Node(int val) {
        data = val;
        next = null;
    }
}
