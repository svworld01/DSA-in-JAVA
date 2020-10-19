/*
Problem Link - https://www.interviewbit.com/problems/nqueens/
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
N Queens: Example 1
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        int[] q = new int[a];
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        solve(q, 0, result);
        return result;
    }
    
    public static boolean isPossible(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if ((q[i] == q[n]) || Math.abs(q[i] - q[n]) == (n - i))
                return false;
        }
        return true;
    }
    
    
    public static void solve(int[] q, int k, ArrayList<ArrayList<String>> result) {
        int n = q.length;
        if (k == n) 
            result.add(arrToList(q));
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isPossible(q, k)) 
                    solve(q, k + 1, result);
            }
        }
    }
    
    private static ArrayList<String> arrToList(int[] a) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            String s = "";
            for (int j = 0; j < a.length; j++) {
                if (a[i] == j) s+="Q";
                else s +=".";
            }
            res.add(s);
        }
        return res;
    }
}
