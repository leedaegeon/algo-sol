import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
//         1. n을 k진수로 바꾸기
//         2. 0을 기준으로 파싱하기(각 수에는 0이 없음)
//         3. 나뉘어진 수 소수 판별
        
        String numStr = "0";
        StringBuilder sb = new StringBuilder();
        while(n >= k){
            sb.append(n%k);
            n /= k;
        }
        sb.append(n%k);
        sb.reverse();
        numStr = sb.toString();

        StringTokenizer st = new StringTokenizer(numStr, "0");
        Set<Long> hs = new HashSet<>();
        hs.add(1l);
        
        while(st.hasMoreTokens()){
            long x = Long.parseLong(st.nextToken());
            boolean flag = false;

            if(hs.contains(x)){
                continue;
            }
            
            for(long i=2l; i<(long)Math.sqrt(x) + 1l; i++){
                if(x%i == 0){  
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }else{
                flag = false;
                hs.add(x);
            }
            
        }
        return answer;
    }
}