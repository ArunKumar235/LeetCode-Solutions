class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    count++;
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }
}