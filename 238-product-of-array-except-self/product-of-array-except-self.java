class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int pProd = 1;
        int sProd = 1;
        for(int i = 0; i<l; i++){
            // if(nums[i]==0) continue;
            pProd*=nums[i];
            sProd*=nums[l-i-1];

            prefix[i] = pProd;
            suffix[l-i-1] = sProd;
        }
        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(suffix));
        int[] res = new int[l];
        res[0] = suffix[1];
        res[l-1] = prefix[l-2];
        for(int i = 1; i<l-1; i++){
            res[i] = prefix[i-1]*suffix[i+1];
        }


        return res;
    }
}