import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }
        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            
            int flag = 0;
            for(int[] next : q) {
                
                if(next[1] > curr[1]) {
                    flag = 1;
                }
                
            }
            if(flag == 1) {
                q.offer(curr);
            }
            else {
                answer++;
                if(curr[0] == location) {
                    break;
                }
            }
            
            
            
            
        }
        
        
        
        return answer;
    }
}