class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int now = 0;
        int i = 1;
        while(i <= n){
            // if(now < stations.length && i < stations[now] - w){
            //     answer++;
            //     i += w * 2 + 1;
            // }
            // else if(now<stations.length && i>= stations[now]-w){
            //     i = stations[now] + w + 1;
            //     now++;
            // }
            if(now < stations.length && i >= stations[now] - w){
                i = stations[now++] + w + 1;
            }
            else{
                answer++;
                i += w * 2 + 1;
            }
        }
        return answer;
    }
}
            