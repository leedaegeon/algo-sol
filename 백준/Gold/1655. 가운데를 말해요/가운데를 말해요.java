import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] keys = new int[n];
        for(int i=0; i<n; i++){
            keys[i] = Integer.parseInt(br.readLine());
        }
//        long startTime = System.currentTimeMillis();
        PriorityQueue<Integer> minStore = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxStore = new PriorityQueue<>();
        int answer;
        for(int i=0; i<n; i++){
            int key = keys[i];
            if(minStore.isEmpty() || key <= minStore.peek()){
                minStore.add(key);
            }else{
                maxStore.add(key);
            }

            while(minStore.size() < maxStore.size()){
                minStore.add(maxStore.poll());
            }
            while(minStore.size() -1 > maxStore.size()){
                maxStore.add(minStore.poll());
            }
            answer = minStore.peek();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
//        System.out.println(System.currentTimeMillis() - startTime);
    }


}