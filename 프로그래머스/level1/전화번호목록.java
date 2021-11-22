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

//정확성 통과,  시간초과
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<>();
        for(String phone : phone_book) {
            hm.put(phone, phone.length());
        }
        System.out.println(phone_book[0]);
        for(int i=0; i<phone_book.length; ++i) {
            String phone = phone_book[i];
            int pLength = hm.get(phone);
            for(int j=0; j<phone_book.length; ++j) {
                if(pLength <  phone_book[j].length()) {
                    if(hm.containsKey(phone_book[j].substring(0,pLength))) {
                        answer = false;
                        return answer;
                    }
                }                
            }
        }
        return answer;
    }
}