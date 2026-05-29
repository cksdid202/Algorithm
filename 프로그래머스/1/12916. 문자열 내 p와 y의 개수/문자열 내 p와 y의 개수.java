class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int cnt1 = 0;
        int cnt2 = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) == 'p') {
                cnt1++;
            }
            if(s.charAt(i) == 'y') {
                cnt2++;
            }
            
        }
        if(cnt1 != cnt2) {
            answer = false;
        }
        

        return answer;
    }
}