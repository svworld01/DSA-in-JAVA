/*
GeekForGeeks : https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
OUTPUT:
Solution :
0 5 8 9
INF 0 3 4
INF INF 0 1
INF INF INF 0
*/
import java.util.*;

public class FloydWarshalsAlgorithm {
    final static int INF = 99999;
    public static void main(String[] args) {
        int graph[][] = { {0, 5, INF, 10}, 
						{INF, 0, 3, INF}, 
						{INF, INF, 0, 1}, 
						{INF, INF, INF, 0} }; 
        floydWarshall(graph);
    }
   public static  void floydWarshall(int graph[][]) { 
    int V = graph.length;
		int dist[][] = new int[V][V]; 
		int i, j, k; 
		for (i = 0; i < V; i++) 
			for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
        
		for (k = 0; k < V; k++){ 
			for (i = 0; i < V; i++){ 
				for (j = 0; j < V; j++){ 
					if (dist[i][k] + dist[k][j] < dist[i][j]) 
						dist[i][j] = dist[i][k] + dist[k][j]; 
				} 
			} 
        } 
        System.out.println("Solution : ");
		for (i=0; i<V; ++i){ 
			for (j=0; j<V; ++j){ 
				if (dist[i][j]==INF) 
					System.out.print("INF "); 
				else
					System.out.print(dist[i][j]+" "); 
			} 
			System.out.println(); 
		}  
    } 
}
