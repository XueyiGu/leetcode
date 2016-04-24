public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        
        int i = 0;
        int j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i <= j){
            if(isVowels(ch[i])){
                if(isVowels(ch[j])){
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                    i++;
                    j--;
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return new String(ch);
    }
    
    public boolean isVowels(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}