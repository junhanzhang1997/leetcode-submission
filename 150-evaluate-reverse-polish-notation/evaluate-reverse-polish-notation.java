class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String x:tokens){
            if(x.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(x.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if(x.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(x.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.valueOf(x));
            }
        }
        return stack.pop();
    }
}