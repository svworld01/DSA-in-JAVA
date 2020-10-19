/*
Problem Link - https://www.interviewbit.com/problems/letter-phone/
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.
*/
public class Solution {
    String[] arr = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res = new ArrayList<>();
        solve(A, res, "", 0);
        return res;
    }
    
    private void solve(String s, ArrayList<String> res, String op, int index) {
        if(index == s.length()){
            res.add(op);
            return;
        }
        int id = s.charAt(index) - '0';
        String str =  arr[id];
        for(int i=0; i< str.length(); i++){
            solve(s, res, op+str.charAt(i), index+1);
        }
    }
}
