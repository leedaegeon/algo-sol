import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        int answer = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.number == k) {
                answer = Math.min(answer, now.cnt);
            }
            if(now.number>0 && now.number<100_000 && set.add(now.number*2)) {
                q.offer(new Node(now.number * 2, now.cnt));
            }
            if(now.number > 0 && set.add(now.number-1)) {
                q.offer(new Node(now.number - 1, now.cnt + 1));
            }
            if(now.number <= k && set.add(now.number+1)){
                q.offer(new Node(now.number + 1, now.cnt + 1));
            }


        }
        System.out.println(answer);
    }
    static class Node {
        int number;
        int cnt;
        Node(int number, int cnt){
            this.number = number;
            this.cnt = cnt;
        }

    }
}