class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    // 최솟값도 함께 관리 
    public void push(int val) {
        stack.push(val);
        // 현재 최솟값과 val 비교해서 더 작은값을 minStack에 추가
        int currentMin = minStack.isEmpty() ? 
        val : Math.min(minStack.peek(), val);

        minStack.push(currentMin);
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()){
            return stack.peek();
        } 

        return -1;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
