class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
//stack will represent the indices which has not found a warmer day yet
    int[] res=new int[temperatures.length];
    Stack<Integer> stack=new Stack<>();
    
    for(int i=0; i<temperatures.length; i++){
        while(!stack.isEmpty() &&            temperatures[i]>temperatures[stack.peek()]){
            int prev=stack.pop();
            res[prev]=i-prev;
        }
        stack.push(i);
    }
    return res;
    }
}
