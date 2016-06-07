class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top(){
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
