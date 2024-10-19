import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static TriNode root = new TriNode();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        String[] pre = new String[m];

        for(int i=0; i<n; i++){
            words[i] = br.readLine();
            insert(words[i]);
        }
        int answer = 0;
        for(int i=0; i<m; i++){
            pre[i] = br.readLine();
            if(searchPrefix(pre[i])){
                answer++;
            }
        }
        System.out.println(answer);

    }
    static boolean searchPrefix(String pre){
        TriNode current = root;
        for(char c: pre.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
    static void insert(String word){
        TriNode current = root;
        for(char c: word.toCharArray()){
            current.children.putIfAbsent(c, new TriNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }
    static class TriNode{
        Map<Character, TriNode> children;
        boolean isEndOfWord;
        TriNode(){
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
}