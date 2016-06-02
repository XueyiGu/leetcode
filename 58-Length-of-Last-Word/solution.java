public class Solution {
    public int lengthOfLastWord(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int right = s.length() - 1;
        while(right > -1 && s.charAt(right) == ' '){
            right--;
        }
        if(right < 0){
            return 0;
        }
        int left = right - 1;
        while(left > -1 && s.charAt(left) != ' '){
            left --;
        }
        return right - left;
    }
}