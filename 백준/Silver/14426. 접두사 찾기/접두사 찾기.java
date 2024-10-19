import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        String[] pre = new String[m];

        for(int i=0; i<n; i++){
            words[i] = br.readLine();
        }
        Arrays.sort(words);
        int answer = 0;
        for(int i=0; i<m; i++){
            pre[i] = br.readLine();
        }
        for(int i=0; i<m; i++){
            if(binSearch(words, pre[i], i)){
//                System.out.println(pre[i]);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean binSearch(String[] words, String pre, int i) {
        int l = 0;
        int r = words.length;
        int len = pre.length();
        while(l < r){
            int mid = l + (r-l)/2;
            String sub = words[mid].substring(0, len);
            if(sub.equals(pre)){
                return true;
            }else{
                if(sub.compareTo(pre) < 0){
//                    System.out.println(sub + " " + pre);
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
        }
        return false;
    }
}