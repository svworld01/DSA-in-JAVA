/*
Problem Link - https://www.interviewbit.com/problems/sudoku/
*/
public class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solve(a, 0, 0);
    }
    private boolean solve(ArrayList<ArrayList<Character>> a, int row, int col){
        if(row == 9)
            return true;
        if(col == 9)
            return solve(a, row+1, 0);
        if(a.get(row).get(col) != '.')
            return solve(a, row, col+1);
        for(char c='1'; c<='9'; c++){
            if(isValid(a, row, col, num)){
                a.get(row).set(col, c);
                if(solve(a, row, col+1))
                    return true;
                a.get(row).set(col, '.'); //backtrack
            }
        }
    }
    private boolean isValid(ArrayList<ArrayList<Character>> a, int row, int col, char num){
        //check for row and col
        for(int i=0; i<9; i++){
            if(a.get(row).get(i) == num || a.get(i).get(col) == num)
                return false;
        }
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                
            }
        }
    }
}
