class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<n+1; ++i) {
            String binary = Integer.toBinaryString(i);
            int cnt = 0;
            for(int j=0; j<binary.length(); ++j) {
                if(binary.charAt(j) == '1') cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
//내풀이



//베스트 풀이
//dp[index] = dp[index - offset] + 1;
public int[] countBits(int num) {
    int result[] = new int[num + 1];
    int offset = 1;
    for (int index = 1; index < num + 1; ++index){
        if (offset * 2 == index){
            offset *= 2;
        }
        result[index] = result[index - offset] + 1;
    }
    return result;
}