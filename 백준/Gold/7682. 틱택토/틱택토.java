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
            for (int i = 0; i < 9; i++) {
                field[i / 3][i % 3] = str.charAt(i);
            }
            if (!isValid(field)) {
                sb.append("invalid");
            }else{
                sb.append("valid");
            }
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
    public static boolean isValid(char[][] field){
        boolean white = false;
        boolean black = false;
        int totalWhiteCnt = 0;
        int totalBlackCnt = 0;
        for (int i = 0; i < 9; i++) {
            int nowi = i/3;
            int nowj = i%3;
            if (field[nowi][nowj] == 'O') {
                totalWhiteCnt++;

            } else if (field[nowi][nowj] == 'X') {
                totalBlackCnt++;
            }
            for (int dir = 0; dir < 8; dir++) {
                int nexti = nowi;
                int nextj = nowj;
                int whiteCnt = 0;
                int blackCnt = 0;
                if (field[nexti][nextj] == 'O') {
                    whiteCnt++;
                } else if (field[nexti][nextj] == 'X') {
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
        // 누가 승자인지에 따라 흰돌 검은 돌 개수를 체크해서 서로 번갈아가면서 돌을 두었는지 확인해야함
        if(white&!black){
//            O가 이기려면 두 돌 개수가 같은채로 끝나야 함
            if(totalWhiteCnt == totalBlackCnt){
                return true;
            }
        } else if (!white & black) {
//            X가 이기려면 x보다 한개 더 많이 둔 상태에서 판이 끝나야함
            if (totalWhiteCnt + 1 == totalBlackCnt) {
                return true;
            }
        } else if (!white && !black) {
//            승자가 없는 경우는 판을 가득 채우고 X가 O보다 한개 더 많아야 제대로 끝난 판임
            if (totalWhiteCnt + totalBlackCnt == 9 && totalWhiteCnt + 1 == totalBlackCnt) {
                return true;
            }
        }
        return false;
    }
}