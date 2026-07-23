class Solution {
    int lower;
    int upper;
    int count = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        long[] prefix = new long[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        mergeSort(prefix, 0, prefix.length - 1);
        return this.count;
    }

    private void mergeSort(long[] nums, int l, int r){
        if(l>=r) return;

        int m = l + (r-l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);

        countPairs(nums, l, m, r);
        merge(nums, l, m, r);
    }

    private void countPairs(long[] nums, int l, int m, int r){
        int low = m+1;
        int high = m+1;
        
        for(int i = l; i<=m; i++){
            while(low<=r && nums[low]-nums[i] < this.lower){
                low++;
            }
            while(high<=r && nums[high]-nums[i] <= upper){
                high++;
            }
            count += high-low;
        }
    }

    private void merge(long[] nums, int l, int m, int r){
        long[] temp = new long[r-l+1];
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