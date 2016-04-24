public class Solution {
    public int numSquares(int n) 
    {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(n);
        int depth = 1;
        int current = 1;
        int next = 0;
        while(!q.isEmpty()){
            if(current == 0){
                depth++;
                current = next;
                next = 0;
            }
            
            int first = q.remove();
            int root = (int)Math.sqrt(first);
            current--;
            for(int i = root; i > 0; i--){
                if(i * i == first){
                    return depth;
                }else{
                    q.add(first - i * i);
                    next++;
                }
            }
        }
        return -1;
    }
}