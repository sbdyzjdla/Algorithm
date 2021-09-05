import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<>();
        for(String phone : phone_book) {
            hm.put(phone, phone.length());
        }
        for(int i=0; i<phone_book.length; ++i) {
            for(int j=1; j<phone_book[i].length(); ++j) {
                if(hm.containsKey(phone_book[i].substring(0,j))) {
                    answer = false;
                    return answer;
                }      
            }
        }
       return answer;
    }
}