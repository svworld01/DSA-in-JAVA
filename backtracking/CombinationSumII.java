/*
Problem Link - https://www.interviewbit.com/problems/combination-sum-ii/
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Set<ArrayList<Integer>> res = new HashSet<>();
        Collections.sort(A);
        solve(res, new ArrayList<Integer>(), A, B, 0, 0);
        return new ArrayList<ArrayList<Integer>>(res);
    }
    private void solve(Set<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> c, int t, int sum, int k){
        if(sum == t){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(sum > t || k >= c.size())
            return;
        for(int i=k; i<c.size(); i++){
            list.add(c.get(i));
            solve(res,list, c, t, sum+c.get(i), i+1);
            list.remove(list.size() - 1);
        }
    }
}
