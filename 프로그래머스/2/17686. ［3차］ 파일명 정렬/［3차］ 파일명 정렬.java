import java.util.*;
class Solution {
    static String[][] formatFile;
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        formatFile = new String[files.length][3];
        
        for(int i=0; i<files.length; i++){
            int headLen = findHead(files[i]);
            int numberLen = findNum(files[i], headLen);
            formatFile[i][0] = files[i].substring(0,headLen);
            formatFile[i][1] = files[i].substring(headLen, numberLen);            
            formatFile[i][2] = files[i].substring(numberLen, files[i].length());
        }
        Arrays.sort(formatFile, (o1, o2) -> {
            String str1 = o1[0].toLowerCase();
            String str2 = o2[0].toLowerCase();
            if(str1.equals(str2)){
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }else{
                return str1.compareTo(str2);
            }
        });
        
        for(int i=0; i<formatFile.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<3; j++){
                sb.append(formatFile[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public int findHead(String file){
        for(int i=0; i<file.length(); i++){
            // if(file.charAt(i)-'0' >= 0 && file.charAt(i)-'0' <= 9){
            //     return i;
            // }
            if(Character.toString(file.charAt(i)).replaceAll("[0-9]","").equals("")){
                return i;
            }
        }
        return file.length();
    }
    
    public int findNum(String file, int start){
        for(int i=start; i<file.length(); i++){
            // if(file.charAt(i) - '0' < 0 || file.charAt(i) - '0' > 9){
            //     return i;
            // }
            if(!Character.toString(file.charAt(i)).replaceAll("[0-9]","").equals("")){
                return i;
            }
        }
        return file.length();
    }
}