public class FloydWarshallAlgo {
    final static int INF = 99999, V = 4;

    void floydWarshall(int dist[][]){
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j]
                        < dist[i][j])
                        dist[i][j]
                            = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int dist[][]){
        System.out.println( "The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int graph[][] = { { 0, 8, INF, 56 },
                          { INF, 0, 2, INF },
                          { INF, INF, 0, 3 },
                          { INF, INF, INF, 0 } };
        FloydWarshallAlgo fw = new FloydWarshallAlgo();
        fw.floydWarshall(graph);
    }
}

// Output:-
// The following matrix shows the shortest distances between every pair of vertices
// 0   8   10   13   
// INF 0   2   5   
// INF INF 0   3   
// INF INF INF 0   
