/*
GeekForGeeks- https://www.geeksforgeeks.org/strongly-connected-components/
YouTube - https://www.youtube.com/watch?v=Rs6DXyWpWrI
input-
5 5
1 0
0 2
2 1
0 3
3 4
output-
0 1 2
3
4
*/
import java.util.*;
public class KosarajuAlgorithm {
    public static void main(String[] args) {
        int v,e;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        v = s.nextInt();
        e = s.nextInt();
        for(int i=0; i<v; i++){
            g.add(new ArrayList<Integer>());
        }
        for(int i=0; i<e; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            g.get(v1).add(v2);
        }
        kosarajuAlgo(g);
    }

    private static void kosarajuAlgo(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        //filling stack by finishing time
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                fillStack(g, stack, isVisited, i);
            }
        }
        g = getTranspose(g);
        isVisited = new boolean[n];
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!isVisited[v]){
                dfs(g, isVisited, v);
                System.out.println();
            }
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> g, boolean[] isVisited, int v) {
        isVisited[v] = true; 
		System.out.print(v + " "); 
		for (int n: g.get(v)) 
		{ 
			if (!isVisited[n]) 
				dfs(g,isVisited, n); 
		} 
    }

    private static ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> g) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = g.size();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<n; i++){
            for(int adj : g.get(i)){
                graph.get(adj).add(i);
            }
        }
        return graph;
    }

    private static void fillStack(ArrayList<ArrayList<Integer>> g, Stack<Integer> stack, boolean[] isVisited, int i) {
        isVisited[i] = true;
        for(int adj : g.get(i)){
            if(!isVisited[adj]){
                fillStack(g, stack, isVisited, adj);
            }
        }
        stack.push(i);
    }
}

