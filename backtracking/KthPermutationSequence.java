/*
Problem Link - https://www.interviewbit.com/problems/kth-permutation-sequence/
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
 In this case, just concatenate the number to the answer.
so if n = 11, k = 1, ans = "1234567891011" 
Whats the maximum value of n and k?
 In this case, k will be a positive integer thats less than INT_MAX.
n is reasonable enough to make sure the answer does not bloat up a lot. 
*/
public class Solution {
    
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list =  new ArrayList<>();
        ArrayList<Integer> fact = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);
        fact.add(1);
        int tmp = 1;
        for(int i=1; i<=11; i++){
            tmp *= i;
            fact.add(tmp);
        }
        for(int i=12; i<=n; i++) fact.add(Integer.MAX_VALUE);
        if(k > fact.get(n) ) return "";
        return permute(list, fact, k-1);
    }
    
    private String permute(ArrayList<Integer> list, ArrayList<Integer> fact, int k){
        int n = list.size();
        if(n == 0) return "";
        int factorial = fact.get(n-1);
        int index = k / factorial;
        int num = list.get(index);
        list.remove(index);
        k = k % factorial;
        return num + permute(list, fact, k);
    }
    
}
