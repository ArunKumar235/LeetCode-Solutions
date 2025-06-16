class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                }
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(nums[i] > nums[j]){
                    lds[i] = Math.max(lds[i], 1 +lds[j]);
                }
            }
        }

        // System.out.println(Arrays.toString(lis));
        // System.out.println(Arrays.toString(lds));

        int minDelete = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(lis[i] > 1 && lds[i] > 1){
                minDelete = Math.min(
                    minDelete, 
                    n-(lis[i]+lds[i]-1)
                );
            }
        }

        return minDelete;
    }
}