class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] number = new boolean[10];
        
        for(int i = 0; i < numbers.length; i++) {
            number[numbers[i]] = true;
        }
        
        for(int i = 0; i < 10; i++) {
            if(number[i] == false) {
                answer += i;
            }
        }
        
        
        return answer;
    }
}