import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Set;

public class DijkstrasShortPath {
	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pqueue;
	private int V;
	List<List<Node>> adj;

	public DijkstrasShortPath(int V)
	{
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pqueue = new PriorityQueue<Node>(V, new Node());
	}

	public void dijkstra(List<List<Node> > adj, int src){
		this.adj = adj;
		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;
		pqueue.add(new Node(src, 0));
		dist[src] = 0;
		while (settled.size() != V) {
			if (pqueue.isEmpty())
				return;
			int u = pqueue.remove().node;
			if (settled.contains(u))
				continue;
			settled.add(u);
			neighbours(u);
		}
	}

	private void neighbours(int u){
		int edgeDistance = -1;
		int newDistance = -1;
		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);
			if (!settled.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;
				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;
				pqueue.add(new Node(v.node, dist[v.node]));
			}
		}
	}

	public static void main(String arg[]){
		int V = 4;
		int source = 0;
		List<List<Node> > adj = new ArrayList<List<Node> >();
		for (int i = 0; i < V; i++) {
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}
		adj.get(0).add(new Node(1, 6));
		adj.get(0).add(new Node(2, 2));
		adj.get(1).add(new Node(3, 1));
		adj.get(2).add(new Node(1, 3));
		adj.get(2).add(new Node(3, 5));
		DijkstrasShortPath dpq = new DijkstrasShortPath(V);
		dpq.dijkstra(adj, source);
		System.out.println("The shorted path from node :");
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(source + " to " + i + " is " + dpq.dist[i]);
	}
}

class Node implements Comparator<Node> {
	public int node;
	public int cost;
	public Node() {}
	public Node(int node, int cost){
		this.node = node;
		this.cost = cost;
	}
	@Override public int compare(Node node1, Node node2){
	    if (node1.cost > node2.cost)
			return 1;
		if (node1.cost < node2.cost)
			return -1;
		return 0;
	}
}

// Output:-
// The shorted path from node :
// 0 to 0 is 0
// 0 to 1 is 5
// 0 to 2 is 2
// 0 to 3 is 6
