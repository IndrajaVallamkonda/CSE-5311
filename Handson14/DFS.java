import java.io.*;
import java.util.*;

public class DFS {
	private int V;
	private LinkedList<Integer> adj[];
    DFS(int v){
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w){
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	void DFS(int v){
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);
	}

	public static void main(String args[]){
		DFS graphDFS = new DFS(8);
		graphDFS.addEdge(0, 1);    
        graphDFS.addEdge(0, 2);    
        graphDFS.addEdge(0, 3);    
        graphDFS.addEdge(1, 3);    
        graphDFS.addEdge(2, 4);  
        graphDFS.addEdge(3, 5);       
        graphDFS.addEdge(3, 6);    
        graphDFS.addEdge(4, 7);    
        graphDFS.addEdge(4, 5);    
        graphDFS.addEdge(5, 2);    
		System.out.println( "Following is Depth First Traversal " + "(starting from vertex 0)");
		graphDFS.DFS(0);
	}
}

// Output:-
// Following is Depth First Traversal (starting from vertex 0)
// 0 1 3 5 2 4 7 6 
