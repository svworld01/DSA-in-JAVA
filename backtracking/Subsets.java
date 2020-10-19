/*
Problem Link - https://www.interviewbit.com/problems/subset/
Given a set of distinct integers, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :
If S = [1,2,3], a solution is:
[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Collections.sort(A);
        solve(A, res, new ArrayList<Integer>(), 0);
        return res;
    }
    private static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int k) {
        for(int i=k; i<a.size(); i++){
            list.add(a.get(i));
            res.add(new ArrayList<Integer>(list));
            solve(a, res, list, i+1);
            list.remove(list.size() - 1);
        }
        return res;
    }
}
