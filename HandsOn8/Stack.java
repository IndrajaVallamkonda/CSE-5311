public class Stack implements StackInterface {
    private static final int MAX_SIZE = 30;
    private int[] arr;
    private int top;

    public Stack() {
        arr = new int[MAX_SIZE];
        top = -1;
    }

    @Override
    public void push(int data) {
        if (top < MAX_SIZE - 1) {
            arr[++top] = data;
        } else {
            System.out.println("Stack Overflow, exceeded max size 30");
        }
    }

    @Override
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
          System.out.println("Stack is empty");
          return -1;
        } else {
          return arr[top];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
      Stack s = new Stack();
      s.push(10);
      s.push(8);
      s.pop();
      s.push(12);
      System.out.println(s.peek());
      System.out.println("Is Stack empty :" + s.isEmpty());
      s.pop();
      s.pop();
      System.out.println("Is Stack empty :" + s.isEmpty());
    }
}
// Output:
// 12
// Is Stack empty :false
// Is Stack empty :true
