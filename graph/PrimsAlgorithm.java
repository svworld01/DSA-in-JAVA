/*
INPUT-->
9 14 //#vertices #edges
0 1 4 //#src dest weight
0 7 8
1 2 8
1 7 11
2 8 2
2 5 4
2 3 7
3 4 9
3 5 14
4 5 10
6 8 6
6 5 2
6 7 1
7 8 7
OUTPUT:-
0 --> 1
5 --> 2
2 --> 3
3 --> 4
6 --> 5
7 --> 6
0 --> 7
2 --> 8
Total Weight : 37
*/
import java.util.*;

public class PrimsAlgorithm{
    
    static class Edge implements Comparable<Edge>{
        int dest;
        int weight;
        Edge(int d, int w){
            dest = d;
            weight = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static class Pair implements Comparable<Pair>{
        int vertex;
        int key;
        Pair(int v, int k){
            vertex = v;
            key = k;
        }
        @Override
        public int compareTo(Pair p) {
            return this.key  - p.key;
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

        primsMST(graph, V, E);

    }

    private static void primsMST(ArrayList<ArrayList<Edge>> graph, int v, int e) {
        boolean[] mst = new boolean[v];
        int[] key = new int[v];
        int[] parent = new int[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;
        Pair firstPair = new Pair(0, key[0]);
        pq.add(firstPair);
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            mst[pair.vertex] = true;
            for(Edge adjEdge: graph.get(pair.vertex)){
                if(!mst[adjEdge.dest] && key[adjEdge.dest] > adjEdge.weight){
                    key[adjEdge.dest] = adjEdge.weight;
                    parent[adjEdge.dest] = pair.vertex;
                    pq.offer(new Pair(adjEdge.dest, key[adjEdge.dest]));
                }
            }
        }
        //result edges
        System.out.println("RESULT _____>");
        int totalWeight = 0;
        for(int i=1; i<v; i++){
            System.out.println(parent[i]+" --> "+i);
            totalWeight += key[i];
        }
        System.out.println("Total Weight : "+totalWeight);
    }
}
