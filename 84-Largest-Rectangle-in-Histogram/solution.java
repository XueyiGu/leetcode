public class Solution {
    public int largestRectangleArea(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        
        while(i < heights.length){
            if(stack.empty() || heights[i] >= heights[stack.peek()]){
                stack.push(i++);
            }else{
                int p = stack.pop();
                int height = heights[p];
                int width = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
        }
        
        while(!stack.empty()){
            int p = stack.pop();
            int height = heights[p];
            int width = stack.empty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, height * width);
        }
        
        return max;
    }
    
    

    
}