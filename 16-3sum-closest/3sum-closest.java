class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target) < Math.abs(res-target)) res = sum;
                
                if(sum < target){
                    j++;
                }else if (sum > target){
                    k--;
                }else{
                    return target;
                }
            }
        }
        return res;
    }
}