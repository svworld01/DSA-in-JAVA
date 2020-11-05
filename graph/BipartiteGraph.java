/*
GeekForGeeks:  https://www.geeksforgeeks.org/bipartite-graph/
*/
import java.util.*;
public class BipartiteGraph 
{  
	public static boolean isBipartite(int G[][],int src) { 
        int V = G.length;
		int colorArr[] = new int[V]; 
		for (int i=0; i<V; ++i) 
			colorArr[i] = -1; 
		colorArr[src] = 1; 
		LinkedList<Integer>q = new LinkedList<Integer>(); 
		q.add(src); 
		while (q.size() != 0){ 
			int u = q.poll(); 
			if (G[u][u] == 1) 
				return false; 
			for (int v=0; v<V; ++v){ 
				if (G[u][v]==1 && colorArr[v]==-1){ 
					colorArr[v] = 1-colorArr[u]; 
					q.add(v); 
				}  
				else if (G[u][v]==1 && colorArr[v]==colorArr[u]) 
					return false; 
			} 
		} 
		return true; 
	} 
	public static void main (String[] args){ 
		int G[][] = {{0, 1, 0, 1}, 
	        		{1, 0, 1, 0}, 
			        {0, 1, 0, 1}, 
                    {1, 0, 1, 0} }; 
                     
		if (isBipartite(G, 0)) 
		    System.out.println("Yes"); 
		else
		    System.out.println("No"); 
	} 
}
