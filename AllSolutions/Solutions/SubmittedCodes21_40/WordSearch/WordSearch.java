package SubmittedCodes21_40.WordSearch;


public class WordSearch {

    public boolean isValid(Point point,char[][] board,
                           int[][] vis,String word,int ind){
        int m = board.length;
        int n = board[0].length;

        boolean bound_i = 0 <= point.i && point.i < m;
        boolean bound_j = 0 <= point.j && point.j < n;

        if(bound_i && bound_j && vis[point.i][point.j] != 1
                && board[point.i][point.j] == word.charAt(ind)){
            return true;
        }
        return false;
    }

    public boolean dfs(Point point,char[][] board,int[][] vis,
                       String word,int ind,int[][] dir){

        if(ind == word.length()-1){
            return word.charAt(ind) == board[point.i][point.j];
        }

        vis[point.i][point.j] = 1;

        for(int k = 0; k<dir.length; k++){

            int newi = point.i + dir[k][0];
            int newj = point.j + dir[k][1];

            Point newpoint = new Point(newi,newj);

            if(this.isValid(newpoint,board,vis,word,ind+1)){
                boolean dep = dfs(newpoint,board,vis,word,ind+1,dir);
                if(dep == true){
                    return true;
                }
            }
        }

        vis[point.i][point.j] = 0;
        return false;

    }

    public void initializeZeros(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                matrix[i][j] = 0;
            }
        }
    }

    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0 ||
                word == null || word.length() == 0){
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        this.initializeZeros(vis);

        //d,r,u,l
        int[][] dir = new int[][]{{1,0},
                {0,1},
                {-1,0},
                {0,-1}};

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(this.dfs(new Point(i,j),board,vis,word,0,dir)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
