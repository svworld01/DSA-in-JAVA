/*
Problem Link - https://www.interviewbit.com/problems/subsets-ii/
Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> res = new LinkedHashSet<>();
        res.add(new ArrayList<>());
        Collections.sort(A);
        solve(A, res, new ArrayList<Integer>(), 0);
        return new ArrayList<ArrayList<Integer>>(res);
    }
    private static void solve(ArrayList<Integer> a, Set<ArrayList<Integer>> res, ArrayList<Integer> list, int k) {
        for(int i=k; i<a.size(); i++){
            list.add(a.get(i));
            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            if(!res.contains(res))
            res.add(tmp);
            solve(a, res, list, i+1);
            list.remove(list.size() - 1);
        }
    }
}

