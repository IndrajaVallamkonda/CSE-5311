public class LinkedList implements LinkedListInterface {
    private Node head;

    public LinkedList() {
        head = null;
    }

    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void delete(int data) {
        Node current = head;
        Node prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev != null) {
                prev.next = current.next;
            } else {
                head = current.next;
            }
        }
    }

    @Override
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public Node search(int data) {
      Node current = head;
      while (current != null ) {
          if(current.data == data){
            return current;
          }
          current = current.next;
      }
      return null;
    }

    public static void main(String[] args) {
      LinkedList ll = new LinkedList();
      ll.insert(10);
      ll.insert(8);
      ll.delete(8);
      ll.insert(12);
      ll.insert(14);
      ll.display();
      System.out.println("search element 10:" + ll.search(10));
      System.out.println("search element 15:" + ll.search(15));
    }
}

//Output:-
// 14 12 10
// search element 10:Node@c387f44
// search element 15:null
