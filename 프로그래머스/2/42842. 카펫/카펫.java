class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        /*
        가로 = a;
        세로 = b;
        
        2a + 2b - 4 = brown;
        (a-2)*(b-2) = yellow;
        a*b - 2a - 2b + 4
        */
        
        for(int i = 1; i < 100000; i++) {
            for(int j = i; j < 100000; j++) {
                if(2*j + 2*i - 4 == brown && j*i == brown + yellow) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }
            
            
            
        return answer;
    }
}