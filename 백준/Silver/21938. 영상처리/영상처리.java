import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] display = checkThreshold(br, n, m, new int[n][m]);

        int answer = 0;
        answer = getObjectNumber(n, m, display, answer);
        System.out.println(answer);
    }

    private static int getObjectNumber(int n, int m, int[][] display, int answer) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(display[i][j] == 255){
                    display = getObject(display, i, j, n, m);
                    answer++;
                }
            }
        }
        return answer;
    }

    private static int[][] checkThreshold(BufferedReader br, int n, int m, int[][] display) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int idx = 0;
            for (int j = 1; j <= m * 3; j++) {
                sum += Integer.parseInt(st.nextToken());
                if (j % 3 == 0) {
                    display[i][idx] = sum;
                    sum = 0;
                    idx++;
                }
            }
        }
        int threshold = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (display[i][j] / 3 >= threshold) {
                    display[i][j] = 255;
                } else {
                    display[i][j] = 0;
                }
            }
        }
        return display;
    }

    public static int[][] getObject(int[][] display, int y, int x, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        display[y][x] = 0;
        while(!q.isEmpty()){
            int[] cord = q.poll();
            for(int i=0; i<4; i++){
                int nexty = cord[0] + di[i];
                int nextx = cord[1] + dj[i];
                if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= m || display[nexty][nextx] != 255){
                    continue;
                }
                display[nexty][nextx] = 0;
                q.offer(new int[]{nexty, nextx});
            }
        }

        return display;
    }
}