class MyQueue {
    Stack push = new Stack();
    Stack pop = new Stack();
    // Push element x to the back of queue.
    public void push(int x) 
    {
        while(!pop.empty()){
            push.push(pop.pop());
        }
        push.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() 
    {
        while(!push.empty()){
            pop.push(push.pop());
        }
        pop.pop();
    }

    // Get the front element.
    public int peek() 
    {
        while(!push.empty()){
            pop.push(push.pop());
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