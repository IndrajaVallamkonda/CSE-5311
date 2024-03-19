public interface QueueInterface {
    void enqueue(int data);
    void dequeue();
    int peek();
    boolean isEmpty();
}
