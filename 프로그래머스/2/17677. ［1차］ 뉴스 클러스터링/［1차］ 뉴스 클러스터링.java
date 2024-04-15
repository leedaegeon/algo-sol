import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String repStr1 = str1.toLowerCase();
        String repStr2 = str2.toLowerCase();
        
        List<String> ls1 = new ArrayList<>();
        List<String> ls2 = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<repStr1.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            String newStr1 = repStr1.charAt(i)+"";
            String newStr2 = repStr1.charAt(i+1)+"";
            newStr1 = newStr1.replaceAll("[^A-Za-z]", "");
            newStr2 = newStr2.replaceAll("[^A-Za-z]", "");
            
            sb.append(newStr1);
            sb.append(newStr2);
            if(sb.length() ==2){
                ls1.add(sb.toString());
            }
        }
        for(int i=0; i<repStr2.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            String newStr1 = repStr2.charAt(i)+"";
            String newStr2 = repStr2.charAt(i+1)+"";
            newStr1 = newStr1.replaceAll("[^A-Za-z]", "");
            newStr2 = newStr2.replaceAll("[^A-Za-z]", "");
            
            sb.append(newStr1);
            sb.append(newStr2);
            if(sb.length() ==2){
                ls2.add(sb.toString());
            }
        }
        // System.out.print(ls1);
        // System.out.print(ls2);
        if(ls1.size() == 0 && ls2.size()==0){
            return 65536;
        }
        
        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for(int i=0; i<ls1.size(); i++){
            int idx = -1;
            for(int j=0; j<ls2.size(); j++){
                if(ls1.get(i).equals(ls2.get(j))){
                    idx = j;
                    break;
                }
            }
            if(idx!=-1){
                inter.add(ls2.get(idx));
                ls2.remove(ls2.get(idx));
                union.add(ls1.get(i));
                
            }else{
                union.add(ls1.get(i));
            }
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