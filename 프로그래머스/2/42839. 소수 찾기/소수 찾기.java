import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        String[] sArr = numbers.split("");
        visited = new boolean[sArr.length];
        
        Arrays.sort(sArr, (o1, o2) ->{
            return o2.compareTo(o1);
        });
        StringBuilder sb = new StringBuilder();
        for(String s: sArr){
            sb.append(s);
        }
        int max = Integer.parseInt(sb.toString());
        boolean[] eratos = new boolean[max+1];
        Arrays.fill(eratos, true);
        eratos[0] = false;
        
        eratos[1] = false;
        for(int i=2; i<max+1; i++){
            for(int j=i+i; j<max+1; j+=i){
                eratos[j] = false;
            }
        }
        // for(int i=1; i<eratos.length; i++){
        //     System.out.println(i + " " + eratos[i]);
        // }
        
        perm(0, new String(), sArr);
        for(int i: set){
            if(eratos[i]){
                answer++;
            }
        }
        
        return answer;
    }
    public void perm(int cnt, String str, String[] sArr){
        if(str.length()>=1){
            set.add(Integer.parseInt(str));
        }
        if(cnt == sArr.length){
            return;
        }
        
        for(int i=0; i<sArr.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            perm(cnt+1, str + sArr[i], sArr);
            visited[i] = false;
            perm(cnt+1, str, sArr);
        }
        
        
    }
    
}