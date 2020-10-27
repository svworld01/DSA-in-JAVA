/*
GeekForGeeks - https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
*/
import java.util.*; 
public class CycleDetectionInDirectedGraph{
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
        System.out.println("Is Cycle Exist? : "+isCycle(g));
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] isVisited = new boolean[n];
        boolean[] stack = new boolean[n];
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                if(isCycle(g, i, stack, isVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> g, int i, boolean[] stack, boolean[] isVisited) {
        if(stack[i])
            return true;
        if(isVisited[i])
            return false;
        isVisited[i] = true;
        stack[i] = true;
        for(int adj: g.get(i)){
            if(isCycle(g, adj, stack, isVisited))
                return true;
        }
        stack[i] = false;
        return false;
    }
    
}
*/
import java.util.*; 
public class CycleDetectionInDirectedGraph{
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
        System.out.println("Is Cycle Exist? : "+isCycle(g));
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> g) {
        int n = g.size();
        boolean[] isVisited = new boolean[n];
        boolean[] stack = new boolean[n];
        for(int i=0; i<n; i++){
            if(!isVisited[i]){
                if(isCycle(g, i, stack, isVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> g, int i, boolean[] stack, boolean[] isVisited) {
        if(stack[i])
            return true;
        if(isVisited[i])
            return false;
        isVisited[i] = true;
        stack[i] = true;
        for(int adj: g.get(i)){
            if(isCycle(g, adj, stack, isVisited))
                return true;
        }
        stack[i] = false;
        return false;
    }
    
}
