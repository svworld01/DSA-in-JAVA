/*
Generate All possible partition of a string.
Ex- 
ip: "aab"
op: [[a, a, b], [a, ab], [aa, b], [aab]]
*/

import java.util.*;
public class GenerateAllPartitionOfString{
    public static void main(String[] args) {
        String s = "aab";
        List<ArrayList<String>> res = new ArrayList<>();
        solve(s, res, new ArrayList<String>());
        System.out.println(res);
    }

    private static void solve(String s, List<ArrayList<String>> res, ArrayList<String> list) {
        if(s.equals("")){
            res.add(new ArrayList<String>(list));
            return;
        }
        //System.out.println("s = "+s);
        for(int i=1; i<=s.length(); i++){
            String tmp = s.substring(0, i);
            list.add(tmp);
            //System.out.println(list);
            solve(s.substring(i,s.length()), res, list);
            list.remove(list.size()  -1);
        }
    }
}
