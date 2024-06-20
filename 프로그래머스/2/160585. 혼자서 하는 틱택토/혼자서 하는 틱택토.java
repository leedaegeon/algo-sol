import java.util.*;
class Solution {
    static List<List<Cord>> permO = new ArrayList<>();
    static List<List<Cord>> permX = new ArrayList<>();
    static int[] di = {0, 1, 1, 1};
    static int[] dj = {1, 1, 0, -1};
    static List<Cord> position = new ArrayList<>();
    
        
    public int solution(String[] b) {
        int answer = -1;
        String[][] board = new String[b.length][b[0].length()];
        for(int i=0; i<b.length; i++){
            board[i] = b[i].split("");
        }
        // for(int i=0; i<board.length; i++){
        //     System.out.println(Arrays.toString(board[i]));
        // }
        position.add(new Cord(0,0));
        position.add(new Cord(1,0));
        position.add(new Cord(2,0));
        position.add(new Cord(0,1));
        position.add(new Cord(0,2));
        List<Cord> cardO = new ArrayList<>();
        List<Cord> cardX = new ArrayList<>();
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j].equals("O")){
                    cardO.add(new Cord(i,j));
                }else if(board[i][j].equals("X")){
                    cardX.add(new Cord(i, j));
                }
            }
        }
        
        
        if(Math.abs(cardO.size() - cardX.size()) >= 2){
            return 0;
        }
        if(cardO.size() == 0 && cardX.size() != 0){
            return 0;
        }
        boolean isOWin = check("O", board);
        boolean isXWin = check("X", board);
        if(cardO.size() == cardX.size() && isOWin && isXWin){
            // System.out.println(isOWin + " " + isXWin);
            
            return 0;
        }        
        if(cardX.size() >= cardO.size() && isOWin){
            // System.out.println(isOWin + " " + isXWin);
            return 0;
        }
        if(cardO.size() != cardX.size() && isXWin){
            // System.out.println(isOWin + " " + isXWin);
            
            return 0;
        }
        
        if(cardX.size() + cardO.size() == 9 && cardX.size() >= cardO.size()){
            return 0;
        }
        if(!isOWin && !isXWin && cardO.size() < cardX.size()){
            return 0;
        }
        return 1;
    }
    
    

    public boolean check( String s, String[][] board){
        // for(int i=0; i<3; i++){
        //     System.out.println(Arrays.toString(board[i]));
        // }
        for(Cord c: position){

            if(board[c.y][c.x].equals(s)){
                for(int dir = 0; dir<4; dir++){
                    int cnt = 1;
                    int nowY = c.y;
                    int nowX = c.x;
                    for(int r=0; r<3; r++){
                        int nextY = nowY + di[dir];
                        int nextX = nowX + dj[dir];
                        if(nextY < 0 || nextY >= 3 || nextX < 0 || nextX >= 3){
                            break;
                        }
                        if(board[nextY][nextX].equals(s)){
                            cnt++;
                        }else{
                            break;
                        }
                        nowY = nextY;
                        nowX = nextX;
                    }
                    if(cnt == 3){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    class Cord {
        int y;
        int x;
        Cord(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}