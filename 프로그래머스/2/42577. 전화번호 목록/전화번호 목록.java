import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phone_set = new HashSet<>();
        for(String phoneNum: phone_book){
            phone_set.add(phoneNum);
        }
        for(String phoneNum : phone_book){
            for(int i=1; i<phoneNum.length(); i++){
                if(phone_set.contains(phoneNum.substring(0,i))){
                    return false;
                }
            }
        }
        
        return answer;
    }
}