class MyQueue {
    Stack push = new Stack();
    Stack pop = new Stack();
    // Push element x to the back of queue.
    public void push(int x) 
    {
        while(!pop.empty()){
            int top = (int) pop.pop();
            push.push(top);
        }
        push.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() 
    {
        while(!push.empty()){
            int top = (int) push.pop();
            pop.push(top);
        }
        pop.pop();
    }

    // Get the front element.
    public int peek() 
    {
        while(!push.empty()){
            int top = (int)push.pop();
            pop.push(top);
        }
        int top = (int)pop.peek();
        return top;
    }

    // Return whether the queue is empty.
    public boolean empty() 
    {
        return push.empty() && pop.empty();
    }
}