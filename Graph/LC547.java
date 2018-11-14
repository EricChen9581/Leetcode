class Solution {
/*
Similar with LC323 using DFS
*/
    int res = 0;
    public int findCircleNum(int[][] M) {
        
        if(M == null || M.length == 0)
            return res;
        int[] visited = new int[M.length];
        
        for(int i = 0; i < visited.length; i ++) {
            if(visited[i] == 0) {
                res++;
                dfs(visited, M, i);
            }
        }
        return res;
    }
    public void dfs(int[] visited, int[][] M, int i) {
        for(int j = 0; j < M[i].length; j ++) {
            if(visited[j] == 0 && M[i][j] == 1){
                visited[j] = 1;
                dfs(visited, M, j);
            }
        }
    }
}
