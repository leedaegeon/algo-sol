class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        perm(0, k, dungeons);
        
        return answer;
    }
    
    public boolean perm(int cnt, int tired, int[][] dungeons){
        
        answer = Math.max(answer, cnt);            
        // System.out.println(cnt);
        if(cnt == dungeons.length){
            return true;
        }

        
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(tired >= dungeons[i][0]){
                // System.out.print(i+" ");
                if(perm(cnt+1, tired-dungeons[i][1], dungeons)){
                    return true;
                }
            }
            visited[i] = false;
        }
        return false;
    }
}