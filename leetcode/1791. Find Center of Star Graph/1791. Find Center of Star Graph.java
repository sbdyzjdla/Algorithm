class Solution {
    public int findCenter(int[][] edges) {
        int eCnt = edges.length;
        int[] degree = new int[edges.length+2];  //vertex의개수4 +1(index 0부터니까)
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if(++degree[u] == eCnt) return u;
            if(++degree[v] == eCnt) return v;
        }
        return 0;
    }
}