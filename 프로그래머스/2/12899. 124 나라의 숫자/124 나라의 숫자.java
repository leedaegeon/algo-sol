import java.util.*;
class Solution {

    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int k = n%3;
            if(k==0){
                sb.append(4);
            }else if(k==1){
                sb.append(1);
            }else if(k==2){
                sb.append(2);
            }
            n--;
            n/=3;
            
        }
        // System.out.println(sb.reverse().toString());
        answer = sb.reverse().toString();
        return answer;
    }
}