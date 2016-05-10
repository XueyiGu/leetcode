public class Solution {
    public String addBinary(String a, String b) 
    {
        if(a == null || a.length() == 0 || a.equals("0")){
            return b;
        }
        
        if(b == null || b.length() == 0 || b.equals("0")){
            return a;
        }
        int m = a.length() - 1;
        int n = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(m > -1 && n > -1){
            int an = Character.getNumericValue(a.charAt(m));
            int bn = Character.getNumericValue(b.charAt(n));
            int sum = an + bn + carry;
            if(sum > 1){
                carry = 1;
                sb.append(String.valueOf(sum % 2));
            }else{
                carry = 0;
                sb.append(String.valueOf(sum));
            }
            m--;
            n--;
        }
        
        while(m > -1){
            int an = Character.getNumericValue(a.charAt(m));
            int sum = an + carry;
            if(sum > 1){
                carry = 1;
                sb.append(String.valueOf(sum % 2));
            }else{
                carry = 0;
                sb.append(String.valueOf(sum));
            }
            m--;
        }
        while(n > -1){
            int an = Character.getNumericValue(b.charAt(n));
            int sum = an + carry;
            if(sum > 1){
                carry = 1;
                sb.append(String.valueOf(sum % 2));
            }else{
                carry = 0;
                sb.append(String.valueOf(sum));
            }
            n--;
        }
        if(carry == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}