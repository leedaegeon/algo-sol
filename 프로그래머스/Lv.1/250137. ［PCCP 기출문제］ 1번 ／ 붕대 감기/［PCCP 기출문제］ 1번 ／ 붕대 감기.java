class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int[] currentHealth = new int[attacks[attacks.length-1][0]+1];
        
        currentHealth[0] = health;
        int persist = bandage[0];
        int recovery = bandage[1];
        int addRec = bandage[2];
        int continueCnt = 0;
        int attIdx = 0;
        
        for(int i=1; i<currentHealth.length; i++){
            if(attacks[attIdx][0] == i){
                currentHealth[i] = currentHealth[i-1] - attacks[attIdx++][1];
                continueCnt = 0;
                if(currentHealth[i] <= 0){
                    // for(int j=0; j<currentHealth.length; j++){
                    //     System.out.print(currentHealth[j] + " ");
                    // }
                    return -1;
                }
            }else{
                
                currentHealth[i] = currentHealth[i-1] + recovery;
                continueCnt++;
                if(persist == continueCnt){
                    currentHealth[i] += addRec;
                    continueCnt = 0;
                }
                // System.out.println(i + " " + continueCnt);
                if(currentHealth[i] > health){
                    currentHealth[i] = health;
                }
                
            }
            
        }
        // for(int j=0; j<currentHealth.length; j++){
        //     System.out.print(currentHealth[j] + " ");
        // }
        answer = currentHealth[currentHealth.length-1];
        return answer;
    }
}