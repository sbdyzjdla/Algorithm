class Solution {
    public int arrayNesting(int[] nums) {
        int answer = 0, cnt = 0;
        for(int k : nums) {
         cnt = nesting(nums, nums.length, k);
         if(cnt > answer) answer = cnt;
        }
        
        return answer;
    }
    
    public static int nesting(int[] nums, int length, int k) {
        int answer = 0;
        boolean[] finnums = new boolean[length];            // 방문했는지체크
        
        while(true) {
            if(nums[k] >= length || finnums[k] == true) {
                return answer;
            } else {
                finnums[k] = true;
                answer++;   
                k = nums[k];
            }
        }
        
    }
}