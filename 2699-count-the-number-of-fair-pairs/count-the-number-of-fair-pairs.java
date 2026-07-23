class Solution {
    int lower;
    int upper;
    long count = 0;
    public long countFairPairs(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        mergeSort(nums, 0, nums.length-1);
        return this.count;
    }

    private void mergeSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int m = l+(r-l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        countPairs(nums, l, m, r);
        merge(nums, l, m, r);
    }

    private void countPairs(int[] nums, int l, int m, int r){
        int low = m+1;
        int high = m+1;

        for(int i = m; i>=l; i--){
            while(low<=r && (long)nums[i]+nums[low] < this.lower){
                low++;
            }
            while(high<=r && (long)nums[i]+nums[high] <= this.upper){
                high++;
            }
            this.count += high-low;
        }
    }

    private void merge(int[] nums, int l, int m, int r){
        int[] temp = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k = 0;

        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i<=m){
            temp[k++] = nums[i++];
        }
        while(j<=r){
            temp[k++] = nums[j++];
        }
        
        for(int x = 0; x<temp.length; x++){
            nums[l+x] = temp[x];
        }
    }
}