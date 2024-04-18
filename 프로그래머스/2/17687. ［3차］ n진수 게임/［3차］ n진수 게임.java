import java.util.*;
class Solution {
    static Map<Integer, String> map = new HashMap<>();
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        if(n>=10){
            char c = 'A';
            for(int i=10; i<16; i++){
                map.put(i, Character.toString(c));
                c++;
            }
        }
        
        int k=0;
        int num=0;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        
        while(k<t){
            String[] numberStrs = toNthStringArr(n, num++);
            // System.out.println(Arrays.toString(numberStrs));
            for(String s: numberStrs){
                if(cnt==p){
                    sb.append(s);
                    k++;
                }
                if(cnt==m){
                    cnt = 1;
                }else{
                    cnt++;
                }
                if(k==t){
                    break;
                }
            }
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
    public String[] toNthStringArr(int n, int num){
        StringBuilder sb = new StringBuilder();
        while(true){
            int k = num%n;
            if(k>=10){
                sb.append(map.get(k));
            }else{
                sb.append(k);
            }
            sb.append(" ");
            num /= n;
            if(num == 0){
                break;
            }
        }
        return sb.reverse().toString().trim().split(" ");
    }
}