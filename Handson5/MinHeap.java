import java.util.*;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    private int parentNode(int i) {
        return (i - 1) >> 1;
    }

    private int leftNode(int i) {
        return (i << 1) + 1;
    }

    private int rightNode(int i) {
        return (i << 1) + 2;
    }

    private boolean validateSwap(int i, int j){
      if( i> 0 && j < heap.size() && heap.get(i).compareTo(heap.get(j)) > 0){
        return true;
      }
      return false;
    }

    private void swapNodes(int i, int j) {
            T temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
    }

    private void heapifyUp(int i) {
      int p= parentNode(i);
        if (i > 0 &&  validateSwap(p,i)) {
            swapNodes(p, i);
            heapifyUp(p);
        }
    }

    private void heapifyDown(int i) {
        int small = i;
        int l = leftNode(i);
        int r = rightNode(i);
        if (l < heap.size() && validateSwap(small, l)){
          small = l;
        }
        if (r < heap.size() && validateSwap(small, r)){
          small = r;
        }
        if (small != i) {
            swapNodes(small, i);
            heapifyDown(small);
        }
    }

    public T getRootNode() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public void pushNode(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T popRoot() {
        if (!heap.isEmpty()){
          T root = heap.get(0);
          heap.set(0, heap.get(heap.size() - 1));
          heap.remove(heap.size() - 1);
          heapifyDown(0);
          return root;
        }
        return null;
    }

    public void buildHeap(List<T> array) {
        heap = new ArrayList<>(array);
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public static void main(String[] args) {
      // integer
        MinHeap<Integer> heapInteger = new MinHeap<>();
        List<Integer> arrInt = List.of(68, 86, 44, 31, 99, 12, 75, 98);
        heapInteger.buildHeap(arrInt);
        System.out.println("Initial Integer heap: " + heapInteger.heap);
        heapInteger.pushNode(21);
        System.out.println("Heap after adding an element: 21 -> " + heapInteger.heap);
        System.out.println("Popping Root: " + heapInteger.popRoot() + "-> " + heapInteger.heap);

       // float
        MinHeap<Float> heap = new MinHeap<>();
        List<Float> arr = List.of(118.4f, 56.2f, 161.1f, 84.3f, 238.6f, 31.7f, 75.3f, 85.9f);
        heap.buildHeap(arr);
        System.out.println("\nInitial Float heap: " + heap.heap);
        heap.pushNode(67.1f);
        System.out.println("Heap after adding an element: 67.1f -> " + heap.heap);
        heap.pushNode(45.1f);
        System.out.println("Heap after adding an element: 45.1f -> " + heap.heap);
        System.out.println("Popping Root: " + heap.popRoot() + "-> " + heap.heap);
        System.out.println("Popping Root: " + heap.popRoot() + "-> " + heap.heap);


        // Student data type
        MinHeap<StudentMarks> minHeapStudent = new MinHeap<>();
        List<StudentMarks> objects = new ArrayList<>();
        objects.add(new StudentMarks("Alex", 70));
        objects.add(new StudentMarks("Sandeep", 65));
        objects.add(new StudentMarks("Anuj", 80));
        objects.add(new StudentMarks("Indu", 75));
        objects.add(new StudentMarks("Carlo", 90));

        minHeapStudent.buildHeap(objects);
        System.out.println("\nInitial Student heap: " + minHeapStudent.heap);
        System.out.println("Popping Root: " + minHeapStudent.popRoot());
        System.out.println("Heap structure: " + minHeapStudent.heap);
    }

    static class StudentMarks implements Comparable<StudentMarks> {
          private String name;
          private int marks;

          public StudentMarks(String name, int marks) {
            this.name = name;
            this.marks = marks;
          }

          @Override
          public int compareTo(StudentMarks o) {
            return Integer.compare(this.marks, o.marks);
          }

          @Override
          public String toString() {
            return "Student{name:" + name + ", marks: "+ marks + '}';
          }
    }
}
/*Output:-
Initial Integer heap: [68, 31, 12, 86, 99, 44, 75, 98]
Heap after adding an element: 21 -> [68, 21, 12, 31, 99, 44, 75, 98, 86]
Popping Root: 68-> [86, 21, 12, 31, 99, 44, 75, 98]

Initial Float heap: [118.4, 56.2, 31.7, 84.3, 238.6, 161.1, 75.3, 85.9]
Heap after adding an element: 67.1f -> [118.4, 56.2, 31.7, 67.1, 238.6, 161.1, 75.3, 85.9, 84.3]
Heap after adding an element: 45.1f -> [118.4, 45.1, 31.7, 67.1, 56.2, 161.1, 75.3, 85.9, 84.3, 238.6]
Popping Root: 118.4-> [238.6, 45.1, 31.7, 67.1, 56.2, 161.1, 75.3, 85.9, 84.3]
Popping Root: 238.6-> [84.3, 45.1, 31.7, 67.1, 56.2, 161.1, 75.3, 85.9]

Initial Student heap: [Student{name:Alex, marks: 70}, Student{name:Sandeep, marks: 65}, Student{name:Anuj, marks: 80}, Student{name:Indu, marks: 75}, Student{name:Carlo, marks: 90}]
Popping Root: Student{name:Alex, marks: 70}
Heap structure: [Student{name:Carlo, marks: 90}, Student{name:Sandeep, marks: 65}, Student{name:Anuj, marks: 80}, Student{name:Indu, marks: 75}]
*/
