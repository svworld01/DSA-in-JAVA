/*
Problem Link - https://www.interviewbit.com/problems/palindrome-partitioning/
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
.
.
.
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
*/
public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        solve(a, res, new ArrayList<String>());
        return res;
    }
    private static void solve(String s, List<ArrayList<String>> res, ArrayList<String> list) {
        if(s.equals("")){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=1; i<=s.length(); i++){
            String tmp = s.substring(0, i);
            if(!isPalindrome(tmp))
            continue;
            list.add(tmp);
            solve(s.substring(i,s.length()), res, list);
            list.remove(list.size()  -1);
        }
    }
    private static boolean isPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
