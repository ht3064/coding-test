class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        answer = Math.max(cnt, answer);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (canMove(k, dungeons, i, visited)) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean canMove(int k, int[][] dungeons, int i, boolean[] visited) {
        return k >= dungeons[i][0] && !visited[i];
    }
}