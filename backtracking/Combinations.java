/*
Problem Link - https://www.interviewbit.com/problems/combinations/
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(n < k)
            return res;
        solve(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    private void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int n, int k, int i){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int j = i; j<=n; j++){
            list.add(j);
            solve(res, list, n, k, j+1);
            list.remove(list.size() - 1);
        }
    }
    
}
