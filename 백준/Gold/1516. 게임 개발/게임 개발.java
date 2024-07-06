import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> order = new ArrayList<>();
        int[] values = new int[n+1];
        int[] inputDegree = new int[n+1];
        for(int i=0; i<n+1; i++){
            order.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            String[] row = br.readLine().split("\\s+");
            values[i+1] = Integer.parseInt(row[0]);
            for(int j=1; j<row.length-1; j++){
                int before = Integer.parseInt(row[j]);
                order.get(before).add(i+1);
                inputDegree[i+1]++;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=1; i<inputDegree.length; i++){
            if(inputDegree[i]==0) {
                pq.offer(new Node(i, values[i]));
            }
        }
        int[] answer = new int[n+1];

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            answer[now.num] = values[now.num];
            for(int next: order.get(now.num)){
                if(--inputDegree[next] == 0){
                    values[next] += answer[now.num];
                    pq.offer(new Node(next, values[next]));
                }
            }
        }
        for(int i=1; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
    static class Node implements Comparable<Node>{
        int num;
        int value;
        Node(int num, int value){
            this.num = num;
            this.value = value;
        }
        public int compareTo(Node n){
            return this.value - n.value;
        }
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o== null || this.getClass() != o.getClass()) {
                return false;
            }
            Node n = (Node) o;
            return this.num == n.num && this.value == n.value;
        }
        public int hashCode(){
            return Objects.hash(num, value);
        }
    }
}