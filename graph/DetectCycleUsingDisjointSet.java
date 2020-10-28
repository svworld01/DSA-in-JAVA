/*
GeekForGeeks - https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
*/
import java.util.*;
//edge impl
class Edge{
    int src, dest;
    Edge(int s, int d){
         src = s;
         dest = d;
    }
}
//subset impl
class Subset{
    int rank, parent;
    Subset(int r, int p){
        rank  = r;
        parent = p;
    }
}
//main class
public class CycleDetectionUsingDisjointSet {
    //main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        int v = s.nextInt();
        int e = s.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0; i<e; i++){
            edges[i] = new Edge(s.nextInt(), s.nextInt());
        }
        System.out.println("is Cycle ? : "+isCycle(edges, v, e));
    }

    private static boolean isCycle(Edge[] edges, int v, int e) {
        Subset[] s = new Subset[v];
        for(int i=0; i<v; i++){
            s[i] = new Subset(0, i);
        }
        for(int i=0; i<e; i++){
            int x = find(s, edges[i].src);
            int y = find(s, edges[i].dest);
            if(x == y)
                return true;
            union(s,x, y);
        }
        return false;
    }
    //find() using path compression method
    private static int find(Subset[] s, int i){
        if(s[i].parent != i)
            s[i].parent = find(s, s[i].parent);
        return s[i].parent;
    }
    //union() using Union by Rank method
    private static void union(Subset[] s, int x, int y){
        int xroot  = find(s, x);
        int yroot = find(s, y);
        if(s[xroot].rank < s[yroot].rank){
            s[xroot].parent = yroot;
        }else if(s[xroot].rank > s[yroot].rank){
            s[yroot].parent = xroot;
        }else{
            s[xroot].parent = yroot;
            s[yroot].rank++;
        }
    } 
}

