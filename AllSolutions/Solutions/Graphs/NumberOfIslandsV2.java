package Solutions.Graphs;

import java.util.*;

public class NumberOfIslandsV2 {

    public int numIslands(char[][] grid) {
        int ans=0;
        int m= grid.length;
        int n= grid[0].length;

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(grid[row][col]=='1'){
                    //findIslandInWater(grid, row, col, m, n);
                    findIslandInWaterUsingBFS(grid, row, col, m, n);
                    ans+=1;
                }
            }
        }
        return ans;
    }

    //Using DFS approach
    private void findIslandInWater(char[][] grid, int currRow, int currCol, int m , int n){
        if(!isValidCell(currRow, currCol, m, n, grid))
            return;

        grid[currRow][currCol]='0';
        findIslandInWater(grid, currRow-1, currCol, m, n); //up
        findIslandInWater(grid, currRow+1, currCol, m, n); //down
        findIslandInWater(grid, currRow, currCol-1, m, n); //left
        findIslandInWater(grid, currRow, currCol+1, m, n); //right

        return;
    }

    //Using BFS approach
    private void findIslandInWaterUsingBFS(char[][] grid, int currRow, int currCol, int m , int n){
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[] {currRow, currCol});

        while(!queue.isEmpty()){
            int[] currCell= queue.remove();
            int row= currCell[0];
            int col= currCell[1];
            if(isValidCell(row,col, m, n, grid)){
                grid[row][col]='0';
                queue.add(new int[]{row-1, col});
                queue.add(new int[]{row+1, col});
                queue.add(new int[]{row, col-1});
                queue.add(new int[]{row, col+1});
            }
        }
        return;
    }


    private boolean isValidCell(int row, int col, int m, int n, char[][] grid){
        if(row<0 || row>=m || col<0 ||col>=n|| grid[row][col]=='0')
            return false;

        return true;
    }

}
