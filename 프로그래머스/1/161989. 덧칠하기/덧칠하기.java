class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int now = 1;
        int idx = 0;
        
        while(now <= n && idx<section.length  ){
            if(now < section[idx] ){
                now++;
            }else if(now == section[idx] ){
                // System.out.println(now);
               
                if(now+m-1 < n){
                    now += m;
                    answer++;
                }else{
                    answer++;
                    break;
                }
                idx++;
            }else{
                idx++;
            }
            // System.out.println(now + " " + section[idx]);
            
        }
        return answer;
    }
}