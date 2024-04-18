import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        Deque<Node> dq = new LinkedList<>();
        dq.offer(new Node(n, 0));
        int answer = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        while (!dq.isEmpty()) {
            Node now = dq.pollFirst();
//            System.out.println(now.number);
            if (now.number == k) {
                answer = now.cnt;
                break;
            }
            if(now.number > 0 && set.add(now.number-1)) {
                dq.addLast(new Node(now.number - 1, now.cnt + 1));
            }
            if(now.number>0 && now.number<k && set.add(now.number*2)) {
                dq.addFirst(new Node(now.number * 2, now.cnt));
            }
            if(now.number <= k && set.add(now.number+1)){
                dq.addLast(new Node(now.number + 1, now.cnt + 1));
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