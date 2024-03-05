import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n == 1 || n == 2){
            return 1;
        }
        while(n > 2){
            if(n%2 == 0){
                n/=2;
            }else{
                n-=1;
                ans++;
            }
            if(n == 2){
                n--;
                ans++;
            }
        }
        
        
        return ans;
    }
}