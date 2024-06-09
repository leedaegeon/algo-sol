import java.util.*;
class Solution {
//     1. 시간 -> 분 단위 변경
//     2. 시작 시간 기준 오름차순 정렬
//     3. plans 큐에 추가(name, start, end)
//     4. 큐에서 하나 꺼낸 뒤 현재 요소 끝 시간과 그 다음 요소 시작 시간 비교
//     4-1. 현재 요소 끝시간 < 다음요소 시작시간 -> 정답에 현재요소 name추가 -> 5번 과정으로 go
//     4-2. 현재 요소 끝시간 == 다음요소 시작시간 -> 정답에 현재요소 name추가 -> 4번 과정으로 go
//     4-3. 현재 요소 끝시간 > 다음요소 시작시간 -> 현재요소 중단 후 대기 스택에(name, 다음요소 시작시간 - 현재요소 끝시간) -> 4번 과정으로 go
//     5. 대기 스택에 과제가 있다면 pop
//     5-1. 대기스택 요소 끝시간 < 다음요소 시작시간 -> 정답에 대기스택 요소 name추가 -> 5번 과정으로 go
//     5-2. 대기스택 요소 끝시간 == 다음요소 시작시간 -> 정답에 대기스택 요소 name추가 -> 4번 과정으로 go
//     5-3. 대기스택 요소 끝시간 > 다음요소 시작시간 -> 대기스택 요소 중단 후 대기스택에(name, 다음요소 시작시간 - 대기요소 끝시간) -> 4번 과정으로 go
    public List<String> solution(String[][] plans) {
        // String[] answer = {};
        List<String> answer = new ArrayList<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>();
        ArrayDeque<Wait> stack = new ArrayDeque<>();
        
        for(String[] p: plans){
            int start = Integer.parseInt(p[1].substring(0,2))*60 + Integer.parseInt(p[1].substring(3,5));
            int end = start + Integer.parseInt(p[2]);
            Plan plan = new Plan(p[0], start, end);
            pq.offer(plan);
        }
        while(!pq.isEmpty() || !stack.isEmpty()){
            Plan now = pq.poll();
            // System.out.println(now);
            boolean flag = false;
            
            if(!pq.isEmpty()){
                Plan next = pq.peek();
                if(now.end < next.start){
                    answer.add(now.name);
                    // System.out.println("1 " + now.name);
                    flag = true;
                }else if(now.end == next.start){
                    answer.add(now.name);
                    // System.out.println("2 " + now.name);   
                    flag = false;
                    
                }else{
                    stack.addFirst(new Wait(now.name, now.end - next.start));
                    flag = false;
                }
            }else{
                answer.add(now.name);
                flag = true;
            }
            int nowTime = now.end;
            while(!stack.isEmpty() && flag){
                Wait wait = stack.removeFirst();
                if(!pq.isEmpty()){
                    Plan next = pq.peek();
                    int nowEnd = nowTime + wait.left;
                    if(nowEnd < next.start){
                        answer.add(wait.name);
                        nowTime = nowEnd;
                        // System.out.println("3 " + now.name);
                        flag = true;
                    }else if(nowEnd == next.start){
                        answer.add(wait.name);
                        // System.out.println("4 " + now.name);
                        flag = false;
                    }else{
                        stack.addFirst(new Wait(wait.name, nowEnd - next.start));
                        flag = false;
                    }
                }else{
                    answer.add(wait.name);
                    nowTime += wait.left;
                }
            }
            // System.out.println(pq.poll());
        }
        return answer;
    }
    class Plan implements Comparable<Plan>{
        String name;
        int start;
        int end;
        Plan(String name, int start, int end){
            this.name = name;
            this.start = start;
            this.end = end;
        }
        public int compareTo(Plan p){
            return this.start - p.start;
        }
        public String toString(){
            return name + " 시작: " + start + " 끝: "+ end;
        }
    }
    class Wait {
        String name;
        int left;
        Wait(String name, int left){
            this.name = name;
            this.left = left;
        }
    }
    
}