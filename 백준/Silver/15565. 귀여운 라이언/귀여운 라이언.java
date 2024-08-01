import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int n, k;
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        input = br.readLine().split("\\s+");
        int[] arr = new int[input.length];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;
        int lion = arr[0] == 1?1:0;
        q.offer(arr[0]);
        int right = 1;
        
        while(right < arr.length){
            q.offer(arr[right]);
            if(arr[right] == 1){
                lion++;
            }
            right++;

            while(!q.isEmpty() && (lion>k || q.peek() == 2)){
                int top = q.poll();
                if(top == 1){
                    lion--;
                }
            }
            if(lion == k){
                answer = Math.min(answer, q.size());
            }
        }


        if(answer == 0 || answer == Integer.MAX_VALUE){
            answer = -1;
        }
        System.out.println(answer);

    }
}