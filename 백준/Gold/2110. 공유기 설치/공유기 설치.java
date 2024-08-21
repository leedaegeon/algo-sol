import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n, c;
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        List<Integer> house = new ArrayList<>();
        int max = 0;
        for(int i=0; i<n; i++){
            house.add(Integer.parseInt(br.readLine()));
        }
//        System.out.println(max);
        Collections.sort(house);
        max = house.get(house.size()-1) - house.get(0) + 1;
        int start = 1;
        int end = max;
        int key = c;
        while(start < end){
            int mid = start + (end - start) / 2;
            int lastHouse = house.get(0);
            int cnt = 1;
//            System.out.println("놓을 수 있는 거리: " + mid);
            for(int i=1; i<house.size(); i++){
                if(house.get(i) - lastHouse >= mid){
                    cnt++;
                    lastHouse = house.get(i);
//                    System.out.print(house.get(i) + " ");

                }
            }

            if(cnt >= key){
                start = mid+1;

            }else{
                end = mid;
            }
//            System.out.println("공유기 놓은 개수: "+ cnt);
        }
        System.out.println(start-1);
    }
}