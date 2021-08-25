class Solution {
    private static int[][]dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,-1}, {-1,1}, {-1,-1}, {1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][n-1] ==1) return -1;
        Queue<int[]> q = new LinkedList<>();
        //System.out.println(grid[0].length);
        
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int sum = 0;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; ++i) {
                int[]pop = q.remove();
                if(pop[0] == n-1 && pop[1] == n-1) {
                    return ++sum;
                }
                for(int k=0; k<8; ++k) {
                    int nextX = dir[k][0] + pop[0];
                    int nextY = dir[k][1] + pop[1];
                    
                    if( nextX >= 0 && nextY >= 0 && nextX <n && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
            sum++;
        }
        return -1;
    }
}