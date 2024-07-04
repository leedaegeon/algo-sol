import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split("\\s+");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] house = new int[n];

        for(int i=0; i<n; i++){
            String site = br.readLine();
            house[i] = Integer.parseInt(site);
        }
        Arrays.sort(house);
        int left = 1;
        int right = house[n - 1] - house[0] + 1;
        while(left < right){
            int mid = left + (right - left)/2;
//            System.out.println(left + " " + right + " " + mid);
//          두 공유기 사이 거리 mid를 최대한으로 -> upper bound를 사용하여 k개를 설치할 수 있기만 한 것이 아니라 k개 설치한
            if(k <= calc(mid, house)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        System.out.println(left-1);
    }
    public static int calc(int dist, int[] house){
        int cnt = 1;
        int last = house[0];
        for(int i=1; i<house.length; i++){
            if(house[i] - last >= dist){
                cnt++;
                last = house[i];
            }
        }
        return cnt;
    }
}