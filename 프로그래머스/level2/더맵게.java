import java.util.*;

// PriorityQueue 사용 (힙)
// 모든 스코빌지수가 K이상이었으면 하는 문제 (될때까지 무한반복함)
// 만족하지 않을경우 생성  ----------->   가장작은 스코빌지수 + (두번째작은 스코빌지수 * 2)

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; ++i) {
            pq.add(scoville[i]);
        }
        int scoville1;
        int scoville2;
        int temp;
        while(true) {
            if(pq.size() <= 1) {       // 섞은 음식의 스코빌지수는 가장작은값 2개를 활용하여 생성하는데 1개이거나 0개이면 생성할수가 없음
                if(pq.peek() >= K) {   // 현재 우선순위가 가장높은값을 출력했을때 K이상이라면
                    return answer;     // 모든 스코빌지수가 K이상이라는 뜻으로 answer 출력        
                } else {
                    return -1;         // 아니라면 모든음식의 스코빌지수를 K이상으로 만들수없기때문에 -1 출력
                }
            }
            scoville1 = pq.poll();
            if(scoville1 <K) {         // 가장 스코빌지수가 낮은값이 K보다 작으면 섞어서 새로운음식을 생성
                scoville2 = pq.poll();
                temp = scoville1 + (scoville2 *2);
                pq.add(temp);
                answer++;
            } else {                   // 가장 스코빌지수가 낮은값이 K보다 크거나 같으면 만족함으로 answer return 
                break;
            }    
        }
        
        return answer;
    }
}