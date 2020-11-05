import java.util.*;
/*
GeekForGeeks : https://www.geeksforgeeks.org/topological-sorting/
INPUT:
4 5
0 1
0 2
1 3
1 2
2 3
OUTPUT:
Topological Order :
0 1 2 3
*/
public class TopologicalOrder {
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
        topologicalOrder(g);
    }

    private static void topologicalOrder(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                topologicalSort(i, isVisited, stack, g);
            }
        }
        System.out.println("Topological Order : ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void topologicalSort(int i, boolean[] isVisited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> g) {
        isVisited[i] = true;
        for(int adj : g.get(i)){
            if(!isVisited[adj]){
                topologicalSort(adj, isVisited, stack, g);
            }
        }
        stack.push(i);
    }

}
