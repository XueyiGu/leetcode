public class Solution {
    public int[] plusOne(int[] digits) 
    {
        if(digits == null || digits.length == 0){
            return null;
        }
        
        int carry = 1;
        int n = digits.length;
        for(int i = n - 1; i > -1; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(carry == 1){
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            for(int i = 0; i < n; i++){
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }else{
            return digits;
        }
    }
}