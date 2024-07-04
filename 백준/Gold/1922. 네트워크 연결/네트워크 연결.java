import javax.xml.xpath.XPathEvaluationResult;
import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(start == end){
                continue;
            }
            pq.offer(new Node(start, end, weight));
        }
        parents = new int[v+1];;
        for(int i=0; i<parents.length; i++){
            parents[i] = i;
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Node edge = pq.poll();

            if(!union(edge.start, edge.end)){
                continue;
            }

//            System.out.println(edge.start + " " + edge.end + " " + edge.weight);
//            System.out.println(Arrays.toString(parents));

            answer += edge.weight;
        }
        System.out.println(answer);
    }
    public static int findParent( int child){
        if(parents[child] == child){
            return child;
        }
        return parents[child] = findParent(parents[child]);
    }
    public static boolean union(int a, int b){
        int parentA = findParent(a);
        int parentB = findParent(b);
        if(parentA == parentB){
            return false;
        }
        if(parentA < parentB){
            parents[parentB] = parentA;
        }else{
            parents[parentA] = parentB;
        }

        return true;
    }
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;
        Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || this.getClass() != o.getClass()){
                return false;
            }
            Node n = (Node) o;
            return this.start == n.start && this.end == n.end;
        }
        public int hashCode(){
            return Objects.hash(this.start, this.end);
        }
    }
}