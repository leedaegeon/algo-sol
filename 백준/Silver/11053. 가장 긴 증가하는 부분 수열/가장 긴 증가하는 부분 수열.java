import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] LIS = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        LIS[0] = 1;
        int answer = 1;
        for(int i=1; i<n; i++){
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[j], LIS[i]);
                }
            }
            LIS[i]+=1;
            answer = Math.max(answer, LIS[i]);
        }
        System.out.println(answer);
    }
}