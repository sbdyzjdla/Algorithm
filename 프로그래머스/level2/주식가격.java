import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<prices.length-1; ++i) {
            int times = 0;
            q.offer(prices[i]);
            for(int j=i+1; j<prices.length; ++j) {
                if(q.peek() <= prices[j]){
                    times++;
                } else {
                    times++;
                    break;
                }
            }
            q.poll();
            answer[i] = times;
        }
        return answer;
    }
}