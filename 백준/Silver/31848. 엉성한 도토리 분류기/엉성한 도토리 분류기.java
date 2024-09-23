import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] holeSizes = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastHoleSize = 0;
        holeSizes[0] = Integer.parseInt(st.nextToken());
        lastHoleSize = holeSizes[0];
        for (int i = 1; i < n; i++) {
            int nowHoleSize = Integer.parseInt(st.nextToken()) + i;
            if(lastHoleSize < nowHoleSize){
                lastHoleSize = nowHoleSize;
            }
            holeSizes[i] = lastHoleSize;

        }
        int dotoriNum = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<dotoriNum; i++){
            int nowDotori = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = n;
            int temp = 0;

            while(left < right){
                int mid = left + (right - left)/2;
                if(holeSizes[mid] >= nowDotori){
                    temp = mid;
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            sb.append(temp+1);
            sb.append(" ");

        }

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);
    }
}