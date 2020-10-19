/*
Problem Link - https://www.interviewbit.com/problems/combination-sum/
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example,
Given candidate set 2,3,6,7 and target 7,
A solution set is:
[2, 2, 3]
[7]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A.size() == 0)
            return res;
        Set<Integer> set = new HashSet<>(A);
        A = new ArrayList<Integer>(set);
        Collections.sort(A);
        solve(res, new ArrayList<Integer>(), A, B, 0, 0);
        return res;
    }
    private void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, ArrayList<Integer> c, int t, int sum, int k){
        if(sum == t){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(sum > t)
            return;
        for(int i=k; i<c.size(); i++){
            list.add(c.get(i));
            solve(res,list, c, t, sum+c.get(i), i);
            list.remove(list.size() - 1);
        }
    }
}
