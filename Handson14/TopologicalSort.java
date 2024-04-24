import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    void topologicalSortUtil(int v, List<List<Integer> > adj, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        stack.push(v);
    }

    void topologicalSort(List<List<Integer>> adj, int V){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, adj, visited, stack);
        }
        System.out.print("Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args){
        int V = 6;

        List<List<Integer> > edges = new ArrayList<>();
        edges.add(Arrays.asList(5, 2));
        edges.add(Arrays.asList(5, 1));
        edges.add(Arrays.asList(4, 3));
        edges.add(Arrays.asList(4, 1));
        edges.add(Arrays.asList(2, 3));
        edges.add(Arrays.asList(3, 1));

        List<List<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> i : edges) {
            adj.get(i.get(0)).add(i.get(1));
        }

        TopologicalSort ts = new TopologicalSort();
        ts.topologicalSort(adj, V);
    }
}

// Output:-
// Topological sorting of the graph: 5 4 2 3 1 0 
