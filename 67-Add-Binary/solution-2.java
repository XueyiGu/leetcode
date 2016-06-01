public class Solution {
    public String addBinary(String a, String b){
        if(a == null || a.length() == 0){
            return b;
        }
        
        if(b == null || b.length() == 0){
            return a;
        }
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i > -1 || j > -1){
            int sum = carry;
            if(i > -1){
                sum += (int)(a.charAt(i--) - '0');
            }
            if(j > -1){
                sum += (int)(b.charAt(j--) - '0');
            }
            
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}