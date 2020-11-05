/*
GeekForGeeks: https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/
OUTPUT:
[1, 1, 1, 1, 1, 1, 1, 1]
[1, 1, 1, 1, 1, 1, 0, 0]
[1, 0, 0, 1, 1, 0, 1, 1]
[1, 3, 3, 3, 3, 0, 1, 0]
[1, 1, 1, 3, 3, 0, 1, 0]
[1, 1, 1, 3, 3, 3, 3, 0]
[1, 1, 1, 1, 1, 3, 1, 1]
[1, 1, 1, 1, 1, 3, 3, 1]
*/
import java.util.*;

public class FloodFillAlgorithm {
    static boolean[][] isVisited;
    static Queue<Point> q;
    static int color;
    static int preColor;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int x, y;
        int[][] data = {
            { 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 0, 0 },
            { 1, 0, 0, 1, 1, 0, 1, 1 },
            { 1, 2, 2, 2, 2, 0, 1, 0 },
            { 1, 1, 1, 2, 2, 0, 1, 0 },
            { 1, 1, 1, 2, 2, 2, 2, 0 },
            { 1, 1, 1, 1, 1, 2, 1, 1 },
            { 1, 1, 1, 1, 1, 2, 2, 1 },
        };
        
        x = 4;
        y = 4; 
        color = 3;
        // Function Call
        fill(data, x, y, color);
    }
    
    private static void fill(int[][] data, int x, int y, int color) {
        int row = data.length;
        int col = data[0].length;
        isVisited = new boolean[row][col];
        q = new LinkedList<>();
        q.add(new Point(x, y));
        preColor = data[x][y];
        data[x][y] = color;
        while(!q.isEmpty()){
            Point p = q.poll();
            int i = p.x;
            int j = p.y;
            //all four surroundings point
            Point upside = new Point(i-1, j);
            fillUtil(upside, data);
            Point downside = new Point(i+1, j);
            fillUtil(downside, data);
            Point leftside = new Point(i, j-1);
            fillUtil(leftside, data);
            Point rightside = new Point(i, j+1);
            fillUtil(rightside, data);
        }
        for(int[] arr : data){
            System.out.println(Arrays.toString(arr));
        }
    }
    private static void fillUtil(Point point, int[][] data){
        int row = data.length; 
        int col = data[0].length;
        if(isValid(point, row, col, data)){
            q.add(point);
            isVisited[point.x][point.y] = true;
            data[point.x][point.y] = color;
        }
    }

    private static boolean isValid(Point p, int n, int m, int[][] data) {
        return p.x>0 && p.y>0 && p.x<n && p.y<m && !isVisited[p.x][p.y] && data[p.x][p.y] == preColor;
    }

}
