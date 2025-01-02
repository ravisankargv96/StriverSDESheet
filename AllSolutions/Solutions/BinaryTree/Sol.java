package BinaryTree;

import java.util.*;

public class Sol {
    public void dfs(String[] Grid, int i, int j, int[] move, int[][] vis){
        if(i<0 || i >= Grid.length || j < 0 || j >= Grid[0].length() || Grid[i].charAt(j) == 'X' || vis[i][j] == move[0]%4 + 1){
            move[0]++;
            return;
        }
        //|| vis[i][j] == 1
        vis[i][j] = (move[0]%4 + 1);

        if(move[0] % 4 == 0){
            // towards right
            int new_i = i + 0;
            int new_j = j + 1;
            dfs(Grid, new_i, new_j, move, vis);
        }

        if(move[0] % 4 == 1){
            // towards down
            int new_i = i + 1;
            int new_j = j + 0;
            dfs(Grid, new_i, new_j, move, vis);
        }

        if(move[0] % 4 == 2){
            // towards left
            int new_i = i + 0;
            int new_j = j - 1;
            dfs(Grid, new_i, new_j, move, vis);
        }

        if(move[0] % 4 == 3){
            // towards up
            int new_i = i - 1;
            int new_j = j + 0;
            dfs(Grid, new_i, new_j, move, vis);
        }

    }
    public int solution(String[] R) {
        // Implement your solution here
        int n = R.length;
        int m = R[0].length();

        int[][] vis = new int[n][m];
        int[] move = new int[1];
        dfs(R,0,0,move,vis);

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] > 0){
                    cnt++;
                }
            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        String[] A = new String[] {"....X..", "X......", ".....X.", "......."}; // 15
        String[] B = new String[] {"...X.", ".X..X", "X...X", "..X.."};
        Sol s = new Sol();
        System.out.println(s.solution(A));



    }
}
