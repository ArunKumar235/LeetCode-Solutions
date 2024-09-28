class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int trappedWater = 0;
        while(left<right){
            if(leftMax<=rightMax){
                trappedWater += leftMax-height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            }else{
                trappedWater += rightMax-height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return trappedWater;
    }
}