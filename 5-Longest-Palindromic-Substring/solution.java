public class Solution {
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() < 2){
            return s;
        }
        
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }
        
        for(int i = n - 1; i > -1; i--){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalindrome[i + 1][j - 1])){
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        int max = 0;
        String result = "";
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome[i][j]){
                    if(j - i + 1 > max){
                        max = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}