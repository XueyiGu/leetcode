/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack stack = new Stack();
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList != null || nestedList.size() != 0){
            for(int i = nestedList.size() - 1; i > -1; i--){
                NestedInteger ni = nestedList.get(i);
                if(ni.isInteger()){
                    stack.push(ni);
                }else{
                    pushList(ni.getList(), stack);
                }
            }
        }
    }
    
    private void pushList(List<NestedInteger> list, Stack stack){
        if(list == null || list.size() == 0){
            return;
        }
        int n = list.size();
        for(int i = n - 1; i > -1; i--){
            NestedInteger ni = list.get(i);
            if(ni.isInteger()){
                stack.push(ni);
            }
            else{
                pushList(ni.getList(), stack);
            }
        }
    }

    @Override
    public Integer next() {
        int result;
        NestedInteger top = (NestedInteger)stack.peek();
        while(!top.isInteger()){
            top = (NestedInteger)stack.pop();
            List<NestedInteger> list = top.getList();
            for(int i = list.size() - 1; i > - 1; i--){
                NestedInteger ni = list.get(i);
                if(ni.isInteger()){
                    stack.push(list.get(i));
                }else{
                    pushList(ni.getList(), stack);
                }
                
            }
            top = (NestedInteger)stack.peek();
        }
        result = top.getInteger();
        stack.pop();
        return result;
    }

    @Override
    public boolean hasNext() {
        return (!stack.empty());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */