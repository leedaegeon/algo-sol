import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int m=1;
        while(t>0){
            t--;
            int n;
            int k;
            boolean flag = false;

            String[] nk = br.readLine().split("\\s+");
            n = Integer.parseInt(nk[0]);
            k = Integer.parseInt(nk[1]);
            String[] stockStr = br.readLine().split("\\s+");
            System.out.println("Case #" + m );
            m++;
            int[] stockArr = new int[n];
            int iter=0;
            for(String s: stockStr){
                stockArr[iter++] = Integer.parseInt(s);
            }
            int[] tails = new int[stockArr.length];
            int maxLen = 0;
            for(int i=0; i<stockArr.length; i++){
                int idx = binSearch(tails, maxLen, stockArr[i]);
                tails[idx] = stockArr[i];
                if(idx == maxLen){
                    maxLen++;
                }
            }
            if(maxLen>=k){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
    public static int binSearch(int[] tails, int maxLen, int key){
        int start = 0;
        int end = maxLen;
        while(start < end){

            int mid = start + (end-start)/2;
//            key가 tails[mid]보다 커야 그 길이의 마지막이 될 수 있음
            if(tails[mid] < key){
                start = mid+1;
            }else {
                end = mid;
            }
        }
        return end;
    }
}