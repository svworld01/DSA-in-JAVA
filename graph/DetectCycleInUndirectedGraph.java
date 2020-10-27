/*
GeekForGeeks - https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
*/
import java.util.*;
public class CycleDetectionInUndirectedGraph {
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
            g.get(v2).add(v1);
        }
        System.out.println(g);
        System.out.println("Is Cycle Exist? : "+isCycle(g));
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] isVisited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                if(dfs(g, i, isVisited, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> g, int i, boolean[] isVisited, int parent) {
        isVisited[i] = true;
        for(int adj : g.get(i)){
            if(!isVisited[adj]){
                if(dfs(g, adj,isVisited, i))
                    return true;
            }else if(adj!=parent){
                return true;
            }
            
        }
        return false;
    }
}
