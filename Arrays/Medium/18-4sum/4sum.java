class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j = i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                long want = (long) target-nums[i]-nums[j];
                int left = j+1;
                int right = nums.length -1;
                while(left<right){
                    if(nums[left]+nums[right]==want){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]<want){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return res;

    }
}