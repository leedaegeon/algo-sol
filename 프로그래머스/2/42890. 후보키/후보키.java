import java.util.*;
class Solution {

    static boolean[] visited;
    static boolean[] visited2;
    static int answer;
    static Set<Set<Integer>> key = new TreeSet<>((o1, o2) -> {
    
        if(o1.size()!= o2.size()){
            return o1.size() - o2.size();
        }else{
            return 1;
        }
    });
    static Set<Set<Integer>> candKey = new HashSet<>();
    static boolean flag;
    public int solution(String[][] relation) {
        
        
        visited = new boolean[relation[0].length];

        for(int i=0; i<=visited.length; i++){
            
            comb(0, i, relation);
        }
        for(Set<Integer> s : key){
            
            List<Integer> sub = new ArrayList<>();
            for(int a: s){
                sub.add(a);
            }
            // Collections.sort(sub);
            
            flag = true;
            visited2 = new boolean[s.size()];

            for(int i=0; i<=s.size(); i++){
                findMin(0, i, sub);
                if(!flag){
                    break;
                }
            }
            if(flag){
                candKey.add(s);
            }
            
        }
//         for(Set<Integer> s: key){
//             System.out.println(s);
//         }
//         System.out.println("=========================");
        
//         for(Set<Integer> s: candKey){
//             System.out.println(s);
//         }
        answer = candKey.size();
        return answer;
    }
    public void findMin(int idx, int cnt, List<Integer> subKey){
        if(cnt == 0){
            Set<Integer> subSet = new HashSet<>();
            for(int i=0; i<visited2.length; i++){
                if(visited2[i]){
                    subSet.add(subKey.get(i));
                }
            }
            // System.out.println(subSet);
            if(candKey.contains(subSet)){
                flag = false;
            }
            return;
        }
        if(idx == subKey.size()){
            return;
        }
        visited2[idx] = true;
        findMin(idx+1, cnt-1, subKey);
        visited2[idx] = false;
        findMin(idx+1, cnt, subKey);
    }
    
    public void comb(int idx, int cnt, String[][] relation){
        if(cnt == 0){
            Set<List<String>> hs = new HashSet<>();
            
            for(int j=0; j<relation.length; j++){
                List<String> hs2 = new ArrayList<>();
                for(int i=0; i<visited.length; i++){
                    if(visited[i]){
                        hs2.add(relation[j][i]);
                    }
                }
                if(!hs.add(hs2)){
                    // for(List<String> s: hs){
                    //     System.out.println(s);
                    // }
                    // System.out.println("----------------------");
                    // System.out.println(hs2);
                    return;
                }
            }
            
            Set<Integer> subKey = new HashSet<>();
            
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    subKey.add(i);
                }
            }
            
            key.add(subKey);
            
            // System.out.println();
            return;
        }
        if(idx == visited.length){
            return;
        }
        visited[idx] = true;
        comb(idx+1, cnt-1, relation);
        visited[idx] = false;
        comb(idx+1, cnt, relation);
    }
    
}