class Solution {
    public boolean isValid(String s) {
       boolean flag=false;
        Stack<Character> stack=new Stack<>();

       for(int i=0; i<s.length(); i++){
        char c=s.charAt(i);
        if(c=='{'||c=='('||c=='['){
            stack.push(c);
        }
        else{
        if(stack.isEmpty()) return false;
        char top=stack.peek();
       if(top=='(' && c==')') stack.pop();
       else if(top=='{' && c=='}') stack.pop();
       else if(top=='[' && c==']') stack.pop();
       else return false; //mismatch handling
        }
       }
        return stack.isEmpty();
    }
}
