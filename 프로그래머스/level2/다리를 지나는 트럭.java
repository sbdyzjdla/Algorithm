import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sumWeight = 0;
        for(int tw : truck_weights) {
            while(true) {
                //System.out.println("tw : " + tw + " answer : " + answer);
                if(q.isEmpty()) {   // 1. 큐가 비어있는경우
                    q.offer(tw);
                    sumWeight += tw;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) { // 2. 큐의크기가 다리길이와 같을떄
                    sumWeight -= q.poll();             // 다리를 다 건넌것과 같으니 빼줌
                } else {    // 이미 지나가는 트럭이있고, 다른트럭이 있을경우
                    if(sumWeight + tw > weight) {
                        answer++;
                        q.offer(0);
                    } else {
                        q.offer(tw);
                        sumWeight += tw;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}