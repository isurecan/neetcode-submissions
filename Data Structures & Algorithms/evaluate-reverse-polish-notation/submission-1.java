class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s: tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int op2=stack.pop();
                int op1=stack.pop();
                int res=0;
                if(s.equals("+")) res=op1+op2;
                else if(s.equals("-")) res=op1-op2;
                else if(s.equals("*")) res=op1*op2;
                else res=op1/op2;
                stack.push(res);
            }
            else
            stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
