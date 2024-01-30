class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int t = brown + yellow;
        
        for(int i = 1; i<Math.sqrt(t)+1; i++){
            if(t%i==0){
                int r = t/i;
                int c = i;
                if((r-2)*(c-2) == yellow){
                    answer[0] = r;
                    answer[1] = c;
                    break;
                }
            }
        }
        
        return answer;
    }
}