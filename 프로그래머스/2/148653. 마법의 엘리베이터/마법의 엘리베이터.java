import java.util.*;
class Solution {
    static int answer = 0;
    
    public int solution(int storey) {
        
        String num = Integer.toString(storey);
        int idx = num.length()-1;
        int k = 1;
        while(idx >=0 && Integer.parseInt(num)!= (int)Math.pow(10, k)){
            int number = num.charAt(idx)-'0';
            int a = Integer.parseInt(num);
            // System.out.println(a);
            
            if(number < 5){
//                 내림
                a /= (int)Math.pow(10, k);
                a *= (int)Math.pow(10, k);
                answer += number;
            }else if(number > 5){
                a /= (int)Math.pow(10, k);
                a += 1;
                a *= (int)Math.pow(10, k);
                answer += 10 - number;
            }else if(idx>0){
                int next = num.charAt(idx-1)-'0';
                
                if(next < 5){
                    a /= (int)Math.pow(10, k);
                    a *= (int)Math.pow(10, k);
                    answer += number;
                }else{
                    a /= (int)Math.pow(10, k);
                    a += 1;
                    a *= (int)Math.pow(10, k);
                    answer += 10 - number;
                }
            }
            num = Integer.toString(a);
            
            idx--;
            k++;
        }
        // System.out.println(num);
        answer += Integer.parseInt(num.substring(0,1));
        
//         if(!num.equals("0") && Integer.parseInt(num)%10 == 0){
            
//         }
        return answer;
    }

   
}