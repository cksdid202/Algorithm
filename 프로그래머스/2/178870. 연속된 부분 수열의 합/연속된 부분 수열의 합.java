class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int cnt = 1000001;
        int currentSum = sequence[0];
        int startI = 0;
        int lastI = 0;
        
        while(right < sequence.length) {
            
            if(currentSum < k) {
                right++;
                if(right < sequence.length) {
                    currentSum += sequence[right];
                }
                
            }
            else if(currentSum > k) {
                left++;
                currentSum -= sequence[left-1];
            }
            else {
                if(right - left + 1 < cnt) {
                    cnt = right - left + 1;
                    startI = left;
                    lastI = right;
                }
                
                currentSum -= sequence[left];
                left++;
            }
            
        }
        
        
        answer[0] = startI;
        answer[1] = lastI;
        
        
        return answer;
    }
}