class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int len = phone_number.length();
        char[] str = new char [len];
        
        for(int i = 0; i < len; i++) {
            
            if(i < len - 4) {
                str[i] = '*';
            }
            else {
                str[i] = phone_number.charAt(i);
            }
            
        }
        answer = new String(str);
        return answer;
    }
}