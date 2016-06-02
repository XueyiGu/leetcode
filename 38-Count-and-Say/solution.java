public class Solution {
    public String countAndSay(int n){
        if(n < 2){
            return "1";
        }
        
        String result = "1";
        for(int i = 1; i < n; i++){
            int left = 0;
            int right = 1;
            StringBuilder sb = new StringBuilder();
            while(right < result.length()){
                if(result.charAt(right) != result.charAt(right - 1)){
                    sb.append(right - left);
                    sb.append(result.charAt(left));
                    left = right;
                    right++;
                }else{
                    right++;
                }
            }
            sb.append(right - left);
            sb.append(result.charAt(left));
            result = sb.toString();
        }
        return result;
    }
   
}