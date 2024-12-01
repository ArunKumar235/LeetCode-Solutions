class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        int i = 0;
        for(int num: nums){
            nums[i++] = 1;
            if(num==0){
                nums[zero++] = 0;
            }else if(num==1){
                one++;
            }else{
                two++;
            }
        }
        while(two>0){
            nums[nums.length-(two--)] = 2;
        }
    }
}