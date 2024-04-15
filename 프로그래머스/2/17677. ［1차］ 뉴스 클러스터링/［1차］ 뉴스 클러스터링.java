import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> ls1 = new LinkedList<>();
        List<String> ls2 = new LinkedList<>();

        for(int i=0; i<str1.length()-1; i++){
            String str = str1.substring(i,i+2).replaceAll("[^A-Za-z]", "").toLowerCase();
            if(str.length() ==2){
                ls1.add(str);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String str = str2.substring(i, i+2).replaceAll("[^A-Za-z]", "").toLowerCase();
            if(str.length() ==2){
                ls2.add(str);
            }
        }
        // System.out.print(ls1);
        // System.out.print(ls2);
        if(ls1.size() == 0 && ls2.size()==0){
            return 65536;
        }
        
        List<String> inter = new LinkedList<>();
        List<String> union = new LinkedList<>();
        
        for(int i=0; i<ls1.size(); i++){
            if(ls2.remove(ls1.get(i))){
                inter.add(ls1.get(i));
            }
            union.add(ls1.get(i));
            
        }
        for(int i=0; i<ls2.size(); i++){
            union.add(ls2.get(i));
        }
        // System.out.println(inter);
        // System.out.println(union);
        answer = 65536*inter.size()/union.size();
        return answer;
    }
}