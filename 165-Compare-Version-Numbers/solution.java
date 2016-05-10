public class Solution {
    public int compareVersion(String version1, String version2) 
    {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i < v1.length && j < v2.length){
            if(Integer.parseInt(v1[i]) == Integer.parseInt(v2[j])){
                i++;
                j++;
            }else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[j])){
                return -1;
            }else{
                return 1;
            }
        }
        while(i < v1.length){
            if(Integer.parseInt(v1[i]) == 0){
                i++;
            }else{
                return 1;
            }
        }
        
        while(j < v2.length){
            if(Integer.parseInt(v2[j]) == 0){
                j++;
            }else{
                return -1;
            }
        }
        return 0;
    }
    
}