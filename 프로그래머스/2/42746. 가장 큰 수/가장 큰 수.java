import java.util.*;
class Solution {
    public String solution(int[] numbers) {

        String[] sorted = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            sorted[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(sorted, (o1, o2) ->{
            while(true){
                if(o1.length() == o2.length()){
                    return Integer.parseInt(o2) - Integer.parseInt(o1);
                }
                if(o1.length() < o2.length()){
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            
                            // return o2.substring(i, i+1).compareTo(o1.substring(i, i+1));
                            return Integer.parseInt(o2.charAt(i)+"") - Integer.parseInt(o1.charAt(i)+"");
                        }
                    }
                    o2 = o2.substring(o1.length());
                }
                if(o1.length() > o2.length()){
                    for(int i=0; i<o2.length(); i++){
                        if(o1.charAt(i) != o2.charAt(i)){
                            // return o2.substring(i, i+1).compareTo(o1.substring(i, i+1));
                            return Integer.parseInt(o2.charAt(i)+"") - Integer.parseInt(o1.charAt(i)+"");
                        }
                    }
                    o1 = o1.substring(o2.length());
                }
            }
        });
        // System.out.println(Arrays.toString(sorted));
        StringBuilder sb = new StringBuilder();
        int zeroCnt = 0;
        for(String str: sorted){
            if(str.equals("0")){
                zeroCnt++;
            }
            sb.append(str);
        }
        if(zeroCnt == sb.length()){
            return "0";
        }
        
        return sb.toString();
    }
}