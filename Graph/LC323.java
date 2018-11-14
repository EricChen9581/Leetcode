/*
**
    323. Number of Connected Components in an Undirected Graph
    Idea1: DFS / BFS
    Similar Questions: LC547, 
*/
import java.util.HashSet;
public class LC323 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }
    public static int countComponents(int n, int[][] edges) {
        if(n <= 1)
            return n;
        if(edges == null || edges.length == 0)
            return n;
        int[][] link = new int[n][n];
        for(int i = 0; i < edges.length; i ++) {
            int first = edges[i][0];
            int second = edges[i][1];
            link[first][second] = 1;
            link[second][first] = 1;
        }
        HashSet<Integer> set2 = new HashSet<>();
        int res = 0;
        for(int i = 0; i < n; i ++) {
            if(!set2.contains(i)) {
                res ++;
                dfs(set2, i, link);
            }
        }
        return res;
    }
    public static void dfs(HashSet<Integer> set, int i, int[][] link){
        for(int j = 0; j < link[i].length; j ++) {
            if(link[i][j] == 0 || set.contains(j))
                continue;
            else {
                set.add(j);
                dfs(set, j, link);
            }
        }
    }
}
