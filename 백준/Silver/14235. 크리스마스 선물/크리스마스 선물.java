import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] terminal = br.readLine().split("\\s+");
            if (Integer.parseInt(terminal[0]) == 0) {
                givePresent(presents, answer);
            } else {
                addPresent(presents, terminal);
            }
        }
        answer.delete(answer.length() - 1, answer.length());
        System.out.println(answer);
    }

    public static void addPresent(PriorityQueue<Integer> presents, String[] terminal) {
        for(int i=1; i<terminal.length; i++){
            presents.offer(Integer.parseInt(terminal[i]));
        }
    }

    public static void givePresent(PriorityQueue<Integer> presents, StringBuilder answer) {
        if (presents.isEmpty()) {
            answer.append(-1);
        } else {
            answer.append(presents.poll());
        }
        answer.append("\n");
    }
}