import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        //범위가 크고 최소를 구하는경우 이분탐색일 가능성 높음   O(logn)
        long answer = 0;
        Arrays.sort(times);
        long left = 1;    //초기값 1로 초기화 (best case)
        long right = n * (long)times[times.length-1]; //가장 오래걸리는 심사관이 전부 심사
                                                //worst case 
        long sum = 0;   //
        while(left<=right) {
            long mid = (left+right) /2;     // 이분 탐색할것 탐색하는데 걸리는 시간
            sum =0;
            for(int time : times) {
                sum += mid / time;
                System.out.println("mid : " + mid + ", sum : " + sum + ", 연산 : " + mid/ time);
            }
            if(sum < n) {       
                left = mid +1;
            } else {
                right = mid -1;
                answer = mid;
            }
        }
        System.out.println("answer : " + answer);
        
        return answer;
    }
}