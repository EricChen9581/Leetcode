/*
    LC 130 Surrounded Regions.
    Description：类似于围棋，数一共有多少个被包围的区域,，被包围的转化成‘X’
    在边缘的不算被包围，是开放的区域
    Idea：DFS, BFS, Union find
    1. DFS
                                              
*/
class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || 
           board[0].length == 0 || board.length == 1)
            return;
        // step1 : four boundary to find "0" and use dfs
        // 'O' -> "*"
        // these 'O' area are open
        int m = board.length - 1;
        int n = board[0].length - 1;
        for(int i = 0; i <= m; i ++) {
            // the first colomn 
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            // the last colomn
            if(board[i][n] == 'O')
                dfs(board, i, n);
        }
        for(int j = 0; j <= n; j ++) {
            // the first row
            if(board[0][j] == 'O')
                dfs(board, 0, j);
            // the last row
            if(board[m][j] == 'O')
                dfs(board, m, j);
        }
        // step2: post-process
        // (1)'O' -> 'X'  these 'O' area are close 
        //  (2)and '*' return to 'O'
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board.length; j ++) {
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;
        board[i][j] = '*';
        // left, right, up, down. four dirctions to use DFS
        if (i > 1 && board[i-1][j] == 'O')
		 dfs(board, i-1, j);
	if (i < board.length - 2 && board[i+1][j] == 'O')
		dfs(board, i+1, j);
	if (j > 1 && board[i][j-1] == 'O')
		dfs(board, i, j-1);
	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
		dfs(board, i, j+1);
    }
}
