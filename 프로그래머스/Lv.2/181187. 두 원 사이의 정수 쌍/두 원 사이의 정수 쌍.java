import java.util.*;
import java.io.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i=1; i<=r2; i++){
            int y2 = (int)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
            int y1 = (int)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
            
            answer += y2-y1+1;
            // System.out.println(y2 + " " + y1);
        }
        
        return answer*4;
    }
}