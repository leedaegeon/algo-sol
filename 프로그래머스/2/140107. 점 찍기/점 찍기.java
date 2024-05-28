class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long r2 = (long)Math.pow(d,2);
        for(int x = 0; (long)Math.pow(x,2) <= r2; x+=k){
            long y = (long)Math.floor(Math.sqrt(Math.pow(d,2) - Math.pow(x,2)));
            answer += y/k;
            answer+=1;
            // System.out.println(x + ", " + y);
        }
        return answer;
    }
}