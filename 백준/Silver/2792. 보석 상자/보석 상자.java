import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jewel = new int[m];
        int start = 1, end = 0;

        for(int i=0; i<m; i++){
            jewel[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, jewel[i]);
        }
//        int temp = 0;
        while(start < end){
            int mid = (start + end) / 2;
            int count = 0;

            for(int j : jewel){
                count += j/mid;
                if(j % mid != 0) count++;
            }

            if(count > n) start = mid + 1;
            else end = mid;
//            temp = mid;
        }
//        System.out.println("mid: " + temp);

        System.out.println(start);
    }
}