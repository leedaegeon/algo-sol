class Solution {
    static int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[][][] memo = new int[users.length][emoticons.length][4];
        int[] threshold = {10, 20, 30, 40};
        
        int[] discount = new int[emoticons.length];

        comb(0, discount, emoticons, threshold, users);
        
        return answer;
    }
    
    public void comb(int idx, int[] discount, int[] emoticons, int[] threshold, int[][] users){
        if(idx == emoticons.length){
            int[] purchase = new int[users.length];
            int regist = 0;
            int value = 0;
   
            for(int i=0; i<users.length; i++){
                int sum = 0;
                for(int j=0; j<emoticons.length; j++){
                    if(users[i][0] <= discount[j]){
                        purchase[i] += (int)(emoticons[j] * (100-discount[j]) * 0.01);
                    }
                }
                if(purchase[i] >= users[i][1]){
                    regist++;
                }else{
                    value += purchase[i] ;
                }
            }
            if(answer[0] < regist || (answer[0] == regist && answer[1] < value)){
                answer[0] = regist;
                answer[1] = value;
            }

            return;
        }
        for(int i=0; i<4; i++){
            discount[idx] = threshold[i];
            comb(idx+1, discount, emoticons, threshold, users);
        }
    }
}