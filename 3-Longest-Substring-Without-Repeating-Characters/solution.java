public class Solution {
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int max = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<Character>();
        while(right < s.length()){
            char ch = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                right++;
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}