//single source shortest path using Dijkstra's Algorithm.
/*
INPUT:
6 8
0 1 2
0 2 4
1 2 1
1 3 7
2 4 3
3 4 2
3 5 1
4 5 5
OUTPUT:
Cost : [0, 2, 3, 8, 6, 9]
Parent : [-1, 0, 1, 4, 2, 3]
*/
import java.util.*;
public class DijkstraAlgorithm {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        Edge(int d, int w){
            dest = d;
            cost = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vertex;
        int dist;
        Pair(int v, int d){
            vertex = v;
            dist = d;
        }
        @Override
        public int compareTo(Pair p) {
            return this.dist  - p.dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0; i<E; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            if(src >= V || dest >= V){
                System.out.println("WRONG INPUT");
                return;
            }
            graph.get(src).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(src, weight));
        }
        dijkstraAlgorithm(graph, 0);
    }
    static void dijkstraAlgorithm(ArrayList<ArrayList<Edge>> graph, int src){
        int n = graph.size();
        int[] dist = new int[n];
        boolean[] sptSet = new boolean[n];
        int[] parent = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;
        pq.offer(new Pair(src, dist[src]));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int v = pair.vertex;
            int d = pair.dist;
            sptSet[v] = true;
            for(Edge edge: graph.get(v)){
                if(!sptSet[edge.dest] && (dist[v] == Integer.MAX_VALUE || dist[v] + edge.cost < dist[edge.dest])){
                    dist[edge.dest] = dist[v] + edge.cost;
                    parent[edge.dest] = v;
                    pq.offer(new Pair(edge.dest, dist[edge.dest]));
                }
            }
        }
        System.out.println("Cost : "+Arrays.toString(dist));
        System.out.println("Parent : "+Arrays.toString(parent));
    }
}
