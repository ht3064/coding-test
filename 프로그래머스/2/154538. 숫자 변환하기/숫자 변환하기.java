import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        
        return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x, 0));
        visited[x] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.num == y) {
                return cur.cnt;
            }
            
            canOp(cur.num + n, y, q, cur);
            canOp(cur.num * 2, y, q, cur);
            canOp(cur.num * 3, y, q, cur);
        }
        
        return -1;
    }
    
    public void canOp(int num, int y, Queue<Node> q, Node node) {
        if (num <= y && !visited[num]) {
            q.add(new Node(num, node.cnt + 1));
            visited[num] = true;
        }
    }
}

class Node {
    int num;
    int cnt;
    
    public Node (int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}