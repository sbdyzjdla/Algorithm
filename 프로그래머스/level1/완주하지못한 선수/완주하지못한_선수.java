import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String part : participant) {
            hm.put(part, hm.getOrDefault(part, 0) +1);
        }
        for(String part : completion) {
            hm.put(part, hm.get(part) -1);
        }
        for(String key : hm.keySet()) {
            if(hm.get(key) != 0) {
                answer += key;
                break;
            }
        }
        return answer;
    }
}