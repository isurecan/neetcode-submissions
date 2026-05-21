class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            if(s.equals("+")||
            s.equals("-")||
            s.equals("*")||
            s.equals("/")){
                int operator2=stack.pop();
                int operator1=stack.pop();
                int result=0;       //initialization is imp!
                if(s.equals("+")) result=operator1+operator2;
                if(s.equals("-")) result=operator1-operator2;
                if(s.equals("*")) result=operator1*operator2;
                if(s.equals("/")) result=operator1/operator2;
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
         return stack.pop();
    }
}
