/*
GeekForGeeks - https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
input:
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4
output:
[src, dest, weight]
[2, 3, 4]
[0, 3, 5]
[0, 1, 10]
*/
import java.util.*;
//class for storing edge
class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int s, int d, int w){
         src = s;
         dest = d;
         weight = w;
    }
    public String toString(){
        return "["+this.src+", "+this.dest+", "+this.weight+"]";
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
//class for maintaing subsets
class Subset{
    int rank, parent;
    Subset(int r, int p){
        rank  = r;
        parent = p;
    }
}
//main class 
public class KrushkalsAlgorithm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); 
        int v = s.nextInt();
        int e = s.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0; i<e; i++){
            int src = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }
        Edge[] result = krushkalsMST(edges, v);
        System.out.println("[src, dest, weight]");
        for(Edge edge: result){
            System.out.println(edge);
        }
    }
    public static Edge[] krushkalsMST(Edge[] edges, int v){
        Edge[] result = new Edge[v-1];
        Subset[] s = new Subset[v];
        int e = 0;
        for(int i=0; i<v; i++){
            s[i] = new Subset(0, i);
        }
        Arrays.sort(edges);
        int i=0; 
        while(e < v-1){
            Edge ne = edges[i++];
            int x = find(s, ne.src);
            int y = find(s, ne.dest);
            if(x!=y){
                result[e++] = ne;
                union(s, x, y);
            }
        }
        return result;
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
