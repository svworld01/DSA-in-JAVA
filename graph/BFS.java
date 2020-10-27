/*
INPUT:
6 7
0 1 0 2 0 3 1 5 2 4 3 4 4 5
BFS :
0 1 2 3 5 4
*/
import java.util.*;
public class BFS {
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
        System.out.println("BFS : ");
        bfs(g);
    }
    //iterative
    private static void bfs(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] check = new boolean[n];
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(0);
        check[0] = true;
        System.out.print(0+" ");
        while(!queue.isEmpty()){
            int v1 = queue.poll();
            for(int v2 : g.get(v1)){
                if(!check[v2]){
                    queue.add(v2);
                    check[v2] = true;
                    System.out.print(v2+" ");
                }
            }
        }
    }
}
