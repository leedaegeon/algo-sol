import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String, String> hm = new HashMap<>();
        
        LinkedList<String> ls = new LinkedList<>();
        
        for(int i=0; i<record.length; i++){
            String[] strArr = record[i].split(" ");
            if(strArr[0].equals("Leave")){
                continue;
            }
            hm.put(strArr[1], strArr[2]);
        }
        // for(Map.Entry<String, String> m : hm.entrySet()){
        //     System.out.println(m.getKey() + " " + m.getValue());
        // }
        for(int i=0; i<record.length; i++){
            String[] strArr = record[i].split(" ");
            if(strArr[0].equals("Enter")){
                ls.add(hm.get(strArr[1]) +"님이 들어왔습니다.");
            }else if(strArr[0].equals("Leave")){
                ls.add(hm.get(strArr[1]) +"님이 나갔습니다.");
            }
        }
        
        answer = new String[ls.size()];
        int idx = 0;
        for(String s: ls){
            answer[idx++] = s;
        }
        // for(int j=0; i<answer.length; i++){
        //     System.out.println(answer[j]);
        // }
        return answer;
    }
}