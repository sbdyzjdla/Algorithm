import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String , String> parentMap = new HashMap<>();
        HashMap<String, Integer> sellerOrder = new HashMap<>();
        for(int i=0; i<enroll.length; ++i) {
            parentMap.put(enroll[i], referral[i]);
            sellerOrder.put(enroll[i], i);
        }
        for(int i=0;i <seller.length; ++i) {
            int profit = amount[i] * 100;
            String sname = seller[i];
            while(!sname.equals("-")) {
                int chToPa = profit / 10;
                int chProfit = profit - chToPa;
                answer[sellerOrder.get(sname)] += chProfit;
                sname = parentMap.get(sname);
                profit = chToPa;
                if(profit < 1) break;
            } 
        }
       
        return answer;
    }
}