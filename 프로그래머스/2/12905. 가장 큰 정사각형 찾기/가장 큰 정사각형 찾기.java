class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
  
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i == 0 || j == 0){
                    answer = Math.max(board[i][j], answer);
                    
                    continue;
                }
                if(board[i][j] == 1){
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                }
                answer = Math.max(board[i][j], answer);
            }
        }
            
        answer = (int)Math.pow(answer, 2);
        // for(int i=0; i<r; i++){
        //     for(int j=0; j<c; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}