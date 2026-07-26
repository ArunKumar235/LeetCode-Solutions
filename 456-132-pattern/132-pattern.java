class Solution {
    static class Pair{
        int val;
        int minLeft;
        Pair(int val, int minLeft){
            this.val = val;
            this.minLeft = minLeft;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int currMin = nums[0];

        for(int i = 1; i<nums.length; i++){
            while(!st.isEmpty() && nums[i] >= st.peek().val){
                st.pop();
            }
            if(!st.isEmpty() && nums[i] < st.peek().val && nums[i] > st.peek().minLeft) 
                return true;
            
            st.push(new Pair(nums[i], currMin));
            currMin = Math.min(nums[i], currMin);
        }

        return false;
    }
}