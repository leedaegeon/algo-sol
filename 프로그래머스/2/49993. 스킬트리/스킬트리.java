import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashSet<Character> hs = new HashSet<>();
        LinkedList<LinkedList<Character>> ls = new LinkedList<>();
        for(int i=0; i<skill_trees.length; i++){
            ls.add(new LinkedList<Character>());
        }
        
        for(int i=0; i<skill.length(); i++){
            hs.add(skill.charAt(i));
        }
        
        for(int i=0; i<skill_trees.length; i++){
            for(int j=0; j<skill_trees[i].length(); j++){
                char c = skill_trees[i].charAt(j);
                if(hs.contains(c)){
                    ls.get(i).add(c);
                }
            }
        }

        boolean flag = true;
        for(int i=0; i<ls.size(); i++){
            for(int j=0; j<ls.get(i).size(); j++){
                if(ls.get(i).get(j) != skill.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }else{
                flag = true;
            }
        }
        
        return answer;
    }
}