package LeetCode60Questions.Recursion;



class WordSearch {

    public class Point{
        int i;
        int j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
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

    public boolean existSol2(char[][] b, String word) {
        /*Find word's first letter.  Then call method to check it's surroundings */
        for(int r=0; r<b.length; r++)
            for(int c=0; c<b[0].length; c++)
                if(b[r][c]==word.charAt(0) && helpSol2(b,word,0,r,c))
                    return true;

        return false;
    }

    public boolean helpSol2(char[][] b, String word, int start, int r, int c){
        /* once we get past word.length, we are done. */
        if(word.length() <= start)
            return true;

        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(r<0 ||c<0 || r>=b.length || c>=b[0].length || b[r][c]=='0' || b[r][c]!=word.charAt(start))
            return false;

        /* set this board position to seen. (Because we can use this postion) */
        char tmp = b[r][c];
        b[r][c] = '0';

        /* recursion on all 4 sides for next letter, if works: return true */
        if(helpSol2(b,word,start+1,r+1,c) ||
                helpSol2(b,word,start+1,r-1,c) ||
                helpSol2(b,word,start+1,r,c+1) ||
                helpSol2(b,word,start+1,r,c-1))
            return true;

        //Set back to unseen
        b[r][c] = tmp;

        return false;
    }
}