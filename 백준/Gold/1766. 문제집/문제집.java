import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> order = new ArrayList<>();
        int[] inputDegree = new int[n+1];

        for(int i=0; i<n+1; i++){
            order.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
//
            order.get(before).add(after);
            inputDegree[after]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<inputDegree.length; i++){
            if(inputDegree[i] == 0){
                pq.offer(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!pq.isEmpty()){
            int now = pq.poll();
            answer.add(now);
            for(int next: order.get(now)){
                if(--inputDegree[next] == 0){
                    pq.offer(next);
                }
            }

        }
        for(int a: answer){
            System.out.print(a + " ");
        }
    }

}