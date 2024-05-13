import java.util.*;
class Solution {
    static char[] target = {'L', 'E'};
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    static boolean[][] visited;
    public int solution(String[] maps) {
        int answer = 0;
        char[][] field = new char[maps.length][maps[0].length()];
        Queue<Node> q = new ArrayDeque<>();
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                field[i][j] = maps[i].charAt(j);
                if(field[i][j] == 'S'){
                    q.offer(new Node(i,j));
                }
            }
        }
        visited = new boolean[field.length][field[0].length];
        // for(char[] cArr: field){
        //     for(char c: cArr){
        //         System.out.print(c + " ");
        //     }
        //     System.out.println();
        // }
        int idx = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int r=0; r<size; r++){
                Node now = q.poll();
                if(visited[now.y][now.x]){
                    continue;
                }
                visited[now.y][now.x] = true;
                
                if(field[now.y][now.x] == target[idx]){
                    if(idx == 1){
                        answer = cnt-1;
                        return answer;
                    }else{
                        visited = new boolean[field.length][field[0].length];
                        idx++;
                        q = new ArrayDeque<>();
                        q.offer(new Node(now.y, now.x));
                        break;
                    }
                }
                
                // System.out.println(now.y + " " + now.x + " " +cnt + " idx: " + idx);
                for(int i=0; i<4; i++){
                    int nexty = now.y + di[i];
                    int nextx = now.x + dj[i];
                    if(nexty < 0 || nexty >= field.length || nextx < 0 || nextx >= field[0].length || field[nexty][nextx] == 'X'){
                        continue;
                    }
                    q.offer(new Node(nexty, nextx));
                }
            }
            cnt++;
        }
        answer = -1;
        return answer;
    }
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}