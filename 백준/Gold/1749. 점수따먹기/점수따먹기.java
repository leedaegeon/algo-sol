import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//
//        30, 30 -60
//        -1  -1  -1
//        30  40  50
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = extracted(n, m, matrix);
        int subMatrix = getSubMatrix(n, m, sum);
        System.out.println(subMatrix);
    }

    private static int getSubMatrix(int n, int m, int[][] sum) {
//        ....
//        ....
//        ....

//        ,,,,
//        ,..,
//        ,..,

//        (i, j) ~ (k,l) 까지의 구간 합
//        sum[k][l] = 0,0 ~ k,l까지의 구간 합
//        sum[i-1][l] = 0,0 ~ i-1,l까지의 구간합
//        sum[k][j-1] = 0,0 ~ k,j-1까지의 구간합
//        sum[i][j] = 0,0 ~ i,j까지의 구간합
//        submatrix = sum[k][l] - sum[i-1][l] - sum[k][j-1] + sum[i-1][j-1]
        int subMatrix = Integer.MIN_VALUE;
//
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                for (int k = i; k <= n; k++) {

                    for (int l = j; l <= m; l++) {
//                        System.out.println(i + ", " + j + " ~ " + k + ", " + l);
//                        System.out.println(sum[k][l] - sum[i-1][l] - sum[k][j-1] + sum[i-1][j-1]);
//                        3,1 ~ 3,3
//                        3, 3 - 2, 3 - 3, 0 + 2,0
                        subMatrix = Math.max(subMatrix, sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1]);
                    }
                }
            }
        }
        return subMatrix;
    }

//      sum[i][j] == i행,j열 까지의 구간합 ...
//                                    ...

//      sum[i][j-1] == i행 j-1열까지의   ..
//                                    ..
    
//      sum[i-1][j] == i-1행 j열까지의   ...
//      sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i][j]
    private static int[][] extracted(int n, int m, int[][] matrix) {
        int[][] sum = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
        return sum;
    }
}