import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> schedule = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            schedule.offer(new Node(start, end));
        }
        int now = 0;
        int answer = 0;
        while(!schedule.isEmpty()){
            Node nowMeeting = schedule.poll();
            if(nowMeeting.start >= now){
//                System.out.println(nowMeeting);
                answer++;
                now = nowMeeting.end;
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node n) {
            if(this.end == n.end){
                return this.start - n.start;
            }else{
                return this.end - n.end;
            }
        }
    }
}