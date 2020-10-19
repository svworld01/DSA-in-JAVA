/*
Problem Link - https://www.interviewbit.com/problems/generate-all-parentheses-ii/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
*/
public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res = new ArrayList<>();        
        solve(res, 0, 0, A, "");
        return res;
    }
    private void solve(ArrayList<String> res, int open, int close, int n, String op) {
        if(open == n && close == n){
            res.add(op);
            return;
        }
        if(open> n || close > n){
            return;
        }
        if(open == close){
            solve(res, open+1, close, n, op+'(');
        }else if(open > close){
            solve(res, open+1, close, n, op+'(');
            solve(res, open, close+1, n, op+')');
        }
    }
}
