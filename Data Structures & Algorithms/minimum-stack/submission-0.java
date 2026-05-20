class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
      stack=new Stack<>();  
      minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else{
            minStack.push(Math.min(minStack.peek(),val));
        }
    }
    
//here the problem guarantees that pop, top and getMin will always be called on non-empty stacks.

    public void pop() {
// each minStack entry corresponds to exact same stack level
            stack.pop();     
            minStack.pop();   
    }
    
    public int top() {
       // if(!stack.isEmpty()) 
       return stack.peek();
    }
    
    public int getMin() {
     //   if(!minStack.isEmpty())
       return minStack.peek();
    }
}
