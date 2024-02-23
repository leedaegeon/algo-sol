import java.util.*;
class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    
    public int solution(String[] board) {
        int answer = 987654321;
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        char[][] field = new char[board.length][board[0].length()];
        int row = field.length;
        int col = field[0].length;
        int[][][] countField = new int[row][col][4];
        // for(int i=0; i<row; i++){
        //     Arrays.fill(countField[i], 10);
        // }
        for(int i=0; i<board.length; i++){
            field[i] = board[i].toCharArray();
        }
        for(Node n: findStart(field)){
            q.offer(n);
        }
        while(!q.isEmpty()){
            Node n = q.poll();
            countField[n.y][n.x][n.dir] = n.cnt;
            // for(int[] arr : countField){
            //     for(int a: arr){
            //         System.out.print(a + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println(n);
            int dir = n.dir;
            int nexty = n.y + di[dir];
            int nextx = n.x + dj[dir];
            if(nexty < 0 || nexty >= row || nextx < 0 || nextx >= col || field[nexty][nextx] == 'D'){
                if(field[n.y][n.x] == 'G'){
                    // for(int j=0; j<4; j++){
                    //     for(int[][] arr2 : countField){
                    //         for(int[] arr: arr2){
                    //             System.out.print(arr[j] + " ");           
                    //         }
                    //         System.out.println();
                    //     }
                    //     System.out.println("========================");
                    // }
                    answer = Math.min(n.cnt, answer);
                }
                
            //이전에 수직방향이었다면 다음에는 수평방향
                for(int i = n.dir%2 == 0? 1 : 0;  i<4; i+=2){
                    nexty = n.y + di[i];
                    nextx = n.x + dj[i];
                    if(nexty < 0 || nexty >= row || nextx < 0 || nextx >= col || field[nexty][nextx] == 'D'){
                        continue;
                    }
                    if(countField[nexty][nextx][i] > n.cnt+1 || countField[nexty][nextx][i] == 0){
                        q.offer(new Node(nexty, nextx, i, n.cnt+1));
                    }
                }
            }else{
                if(countField[nexty][nextx][dir] > n.cnt || countField[nexty][nextx][dir] == 0){
                
                    q.offer(new Node(nexty, nextx, dir, n.cnt));
                }
            }
            
        }
        if(answer == 987654321){
            answer = -1;
        }
        return answer;
    }
    public LinkedList<Node> findStart(char[][] field){
        LinkedList<Node> ls = new LinkedList<>();
        int y = 0;
        int x = 0;
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
                if(field[i][j] == 'R'){
                    y = i;
                    x = j;
                }
            }
        }
        for(int i=0; i<4; i++){
            ls.add(new Node(y,x,i, 1));
        }
        return ls;
    }
    class Node{
        int y;
        int x;
        int dir;
        int cnt;
        Node(){};
        Node(int y, int x, int d, int cnt){
            this.y = y;
            this.x = x;
            this.dir = d;
            this.cnt = cnt;
        }
        public String toString(){
            String direction = "왼쪽";
            if(this.dir == 0){
                direction = "위쪽";
            }else if(this.dir == 2){
                direction = "아래쪽";
            }else if(this.dir == 1){
                direction = "오른쪽";
            }
            return "행: " + this.y + ", 열: " + this.x + " /방향: " + direction + " 방향전환 횟수: " + this.cnt;
        }
    }
}