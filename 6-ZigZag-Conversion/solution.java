public class Solution {
    public String convert(String s, int numRows) 
    {
        if(numRows == 1 || s == null || s.length() < 2){
            return s;
        }
        int n = s.length();
        int p = numRows * 2 - 2;
        int total = n / p;
        
        if(n % p != 0){
            total = total + 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < numRows; j++){
            for(int i = 0; i < total; i++){
                if(j == 0){
                    int index = i * p;
                    if(index < n){
                        sb.append(s.charAt(index));
                    }
                }else if(j == numRows - 1){
                    int index = j + i * p;
                    if(index < n){
                        sb.append(s.charAt(index));
                    }
                }else{
                    int index1 = j + p * i;
                    if(index1 < n){
                        sb.append(s.charAt(index1));
                        int index2 = index1 + (numRows - 1 - j) + (numRows - 2 - j + 1);
                        if(index2 < n){
                            sb.append(s.charAt(index2));
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}