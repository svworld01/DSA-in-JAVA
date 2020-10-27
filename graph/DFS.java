/*
input:
6 7
0 1 0 2 0 3 1 5 2 4 3 4 4 5
DFS : [0, 3, 4, 5, 2, 1]
*/
import java.util.*;
public class DFS {
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
        ArrayList<Integer> list = dfs(g);
        System.out.println("DFS : "+ list);
    }
    //iterative
    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] check = new boolean[n];
        Stack<Integer> stack  = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int v1 = stack.pop();
            if(!check[v1]){
                check[v1] = true;
                res.add(v1);
            }
            for(int v2 : g.get(v1)){
                if(!check[v2])
                    stack.push(v2);
            }
        }
        return res;
    }
}
