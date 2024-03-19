public class Queue implements QueueInterface {
    private static final int MAX_SIZE = 30;
    private int[] arr;
    private int front, rear;

    public Queue() {
        arr = new int[MAX_SIZE];
        front = rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return front > rear;
    }

    @Override
    public void enqueue(int data) {
        if (rear < MAX_SIZE - 1) {
            arr[++rear] = data;
            if (front == -1) {
                front = 0;
            }
        } else {
            System.out.println("Queue Overflow, exceeded max size 30");
        }
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
          System.out.println("Queue is empty");
        } else {
          front++;
          if (front > rear) {
              front = rear = -1;
          }
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
          System.out.println("Queue is empty");
          return -1; // or throw an exception
        } else {
          return arr[front];
        }
    }

    public static void main(String[] args) {
      Queue que = new Queue();
      que.enqueue(10);
      que.enqueue(8);
      que.dequeue();
      que.enqueue(12);
      System.out.println(que.peek());
      System.out.println("Is Queue empty :" + que.isEmpty());
    }
}

// Output:-
// 8
// Is Queue empty :false
