import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] di = {0, 1, 1, 1, 0, -1, -1,-1};
    static int[] dj = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }
            inputList.add(str);
        }
        StringBuilder sb = new StringBuilder();
        for(String str: inputList){
            char[][] field = new char[3][3];

            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < 9; i++) {
                field[i / 3][i % 3] = str.charAt(i);
                if(field[i/3][i%3] == 'O'){
                    cnt1++;
                }else if(field[i/3][i%3] == 'X'){
                    cnt2++;
                }
//                중간에 승자체크를 해주면서 승자가 나왔음에도 게임이 진행되는 것을 확인해야함
            }

            if (!isValid(field)) {
//                invalid
                sb.append("invalid");

            }else{
                sb.append("valid");
            }
            sb.append(" ");
        }
        String[] strs = sb.toString().trim().split(" ");
        for(String str: strs){
            System.out.println(str);
        }
    }
    public static boolean isValid(char[][] field){
        boolean white = false;
        boolean black = false;
        int totalWhiteCnt = 0;
        int totalBlackCnt = 0;
        for (int i = 0; i < 9; i++) {

            if (field[i/3][i%3] == 'O') {
                totalWhiteCnt++;

            } else if (field[i/3][i%3] == 'X') {
                totalBlackCnt++;
            }
            for (int dir = 0; dir < 8; dir++) {
                int nexti = i / 3;
                int nextj = i % 3;
                int whiteCnt = 0;
                int blackCnt = 0;
                if (field[i/3][i%3] == 'O') {
                    whiteCnt++;

                } else if (field[i/3][i%3] == 'X') {
                    blackCnt++;
                }
                for (int m = 0; m < 2; m++) {
                    nexti += di[dir];
                    nextj += dj[dir];
                    if (nexti < 0 || nexti >= 3 || nextj < 0 || nextj >= 3) {
                        break;
                    }
                    if (field[nexti][nextj] == 'O') {
                        whiteCnt++;
                    } else if (field[nexti][nextj] == 'X') {
                        blackCnt++;
                    }
                }
                if (whiteCnt == 3) {
                    white = true;
                }
                if (blackCnt == 3) {
                    black = true;
                }
            }
        }
//        System.out.println(white + " " + black + " : " + totalWhiteCnt + " " + totalBlackCnt);
        if(white&!black){
            if(totalWhiteCnt == totalBlackCnt){
                return true;
            }
        }else if(!white&black){
            if(totalWhiteCnt + 1 == totalBlackCnt){
                return true;
            }
        }else if(!white&&!black){
            if(totalWhiteCnt + totalBlackCnt == 9 && totalWhiteCnt + 1 == totalBlackCnt){
                return true;
            }
        }
        return false;
    }
}