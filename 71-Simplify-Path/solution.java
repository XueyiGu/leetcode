public class Solution {
    public String simplifyPath(String path){
        if(path == null || path.length() == 0){
            return path;
        }
        Stack stack = new Stack();
        int i = 0;
        int j = 1;
        while(j <= path.length()){
            if(j == path.length() || path.charAt(j) == '/'){
                String seg = path.substring(i + 1, j);
                if(seg == null || seg.length() == 0 || seg.equals(".")){
                    i = j;
                    j++;
                }else if(seg.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    i = j;
                    j++;
                }else{
                    stack.push(seg);
                    i = j;
                    j++;
                }
            }else{
                j++;
            }
        }
        
        if(stack.isEmpty()){
            return "/";
        }
        String sb = "";
        while(!stack.isEmpty()){
            String top = (String) stack.pop();
            sb = '/' + top + sb;
        }
        return sb;
    }
}