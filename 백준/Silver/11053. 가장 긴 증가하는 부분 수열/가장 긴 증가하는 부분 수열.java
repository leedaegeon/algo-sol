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
        int[] tails = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int idx = binSearch(tails, maxLen, nums[i]);
            tails[idx] = nums[i];
            if (idx == maxLen) {
                maxLen++;
            }
        }
        System.out.println(maxLen);
    }
    public static int binSearch(int[] tails, int end, int key){
        int start = 0;
        while(start < end){
            int mid = (start + end) / 2;
            if(tails[mid] < key){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}