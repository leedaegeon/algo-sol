import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split("\\s+");
        int n, m;
        n = Integer.parseInt(inputArr[0]);
        m = Integer.parseInt(inputArr[1]);
        inputArr = br.readLine().split("\\s+");
        List<Integer> lecture = new ArrayList<>();
        int start = 1;
        int end = 0;
        for (String s : inputArr) {
            int now = Integer.parseInt(s);
            lecture.add(now);
            start = Math.max(start, now);
            end += now;
        }
        int answer = Integer.MAX_VALUE;
        while(start < end){
            int mid = start + (end - start) / 2;
            int size = 0;
            int cnt = 0;
            for(int l: lecture){
                if(size + l > mid){
                    size = l;
                    cnt++;
                }else{
                    size+=l;
                }
            }
//            블루레이 개수가 m 이상이면 start를 증가시킴
            if(cnt >= m){
                start = mid+1;
            }else{
                end = mid;
            }
//            System.out.println(start + " " + end + " " + mid + " " + cnt);
        }
        System.out.println(start);
    }
}