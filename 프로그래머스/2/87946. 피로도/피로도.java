class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        perm(0, k, dungeons);
        
        return answer;
    }
    
    public void perm(int cnt, int tired, int[][] dungeons){
        
        for(int i=0; i<dungeons.length; i++){
        
            if(!visited[i] && tired >= dungeons[i][0]){
                visited[i] = true;
                perm(cnt+1, tired-dungeons[i][1], dungeons);
                visited[i] = false;
            }
            
        }
        answer = Math.max(answer, cnt);            

    }
}