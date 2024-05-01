import java.util.Map;
import java.util.HashMap;

public class BellmanFord {
    public static Map<String, Integer> bellmanFord(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        for (int i = 0; i < graph.size() - 1; i++) {
            for (Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
                String currentNode = entry.getKey();
                Map<String, Integer> neighbors = entry.getValue();

                for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                    String neighbor = neighborEntry.getKey();
                    int weight = neighborEntry.getValue();
                    int distance = distances.get(currentNode) == Integer.MAX_VALUE ? Integer.MAX_VALUE : distances.get(currentNode) + weight;

                    if (distance < distances.get(neighbor)) {
                        distances.put(neighbor, distance);
                    }
                }
            }
        }

        
        for (int i = 0; i < graph.size() - 1; i++) {
            for (Map.Entry<String, Map<String, Integer>> entry : graph.entrySet()) {
                String currentNode = entry.getKey();
                Map<String, Integer> neighbors = entry.getValue();

                for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                    String neighbor = neighborEntry.getKey();
                    int weight = neighborEntry.getValue();
                    int distance = distances.get(currentNode) == Integer.MAX_VALUE ? Integer.MAX_VALUE : distances.get(currentNode) + weight;

                    if (distance < distances.get(neighbor)) {
                        throw new IllegalArgumentException("Graph contains a negative weight cycle");
                    }
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("A", Map.of("B", 3, "C", 7));
        graph.put("B", Map.of("A", 8, "C", 2));
        graph.put("C", Map.of("A", 5, "B", 1));
      

        String startNode = "A";

            Map<String, Integer> shortestDistances = bellmanFord(graph, startNode);

            System.out.println("Shortest distances from node " + startNode + ":");
            for (Map.Entry<String, Integer> entry : shortestDistances.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
    }
}

// Output:-
// Shortest distances from node A:
// A : 0
// B : 3
// C : 5
