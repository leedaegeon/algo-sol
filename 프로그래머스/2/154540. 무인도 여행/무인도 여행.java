import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    
    public LinkedList<Integer> solution(String[] maps) {
        int[] answer = {};
        char[][] field = new char[maps.length][maps[0].length()];
        visited = new boolean[field.length][field[0].length];
        
        for(int i=0; i<maps.length; i++){
            field[i] = maps[i].toCharArray();
        }
        // for(char[] ca: field){
        //     for(char c: ca){
        //         System.out.print(c+" ");
        //     }
        //     System.out.println();
        // }
        LinkedList<Integer> ls = new LinkedList<>();
        
        for(int i=0; i<field.length; i++){
            for(int j=0; j<field[0].length; j++){
                if(field[i][j] != 'X' && !visited[i][j]){
                    ls.add(bfs(i,j,field));            
                }
            }
        }
        if(ls.isEmpty()){
            ls.add(-1);
        }
        Collections.sort(ls);
        // for(boolean[] ba: visited){
        //     for(boolean b:ba){
        //         System.out.print(b + " ");
        //     }
        //     System.out.println();
        // }
        return ls;
    }
    public int bfs(int starty, int startx, char[][] field){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(starty, startx));
        int sum = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            int y = now.y;
            int x = now.x;
            if(visited[y][x]){
                continue;
            }
            visited[y][x] = true;
            sum += field[y][x]-'0';
            
            for(int i=0; i<4; i++){
                int nexty = y+di[i];
                int nextx = x+dj[i];
                if(nexty < 0 || nexty >= field.length || nextx < 0 || nextx >= field[0].length){
                    continue;
                }
                if(field[nexty][nextx] != 'X' && !visited[nexty][nextx]){
                    q.offer(new Node(nexty, nextx));
                }
            }
        }
        return sum;
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