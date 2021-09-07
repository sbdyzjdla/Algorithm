import java.util.*;

class Solution {
    
    private static int[][]dir = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; ++i) {
                int[]pop = q.remove();
                if(pop[0] == n-1 && pop[1] == m-1) {
                    return ++answer;
                }
                for(int j=0; j<4; ++j) {
                    int nextX = pop[0] + dir[j][0];
                    int nextY = pop[1] + dir[j][1];
                    
                    if(nextX >=0 && nextX < n && nextY >= 0 && nextY < m 
                       && maps[nextX][nextY] == 1 && 
                       !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX,nextY});
                        
                    }
                }
            }
            answer++;
            
        }
        return -1;
    }
}