class Solution {

    class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    int[] res;

    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        
        Pair[] li = new Pair[nums.length];
        for(int i = 0; i<nums.length; i++){
            li[i] = new Pair(nums[i], i);
        }

        mergeSort(li, 0, nums.length-1);

        List<Integer> ans = new ArrayList<>();
        for(int i: res){
            ans.add(i);
        }
        return ans;
    }

    private void mergeSort(Pair[] nums, int l, int r){
        if(l>=r) return;

        int m = l+(r-l)/2;

        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);

        merge(nums, l, m, r);
    }

    private void merge(Pair[] nums, int l, int m, int r){
        Pair[] temp = new Pair[r-l+1];

        int i = l;
        int j = m+1;
        int k = 0;

        int rightCount = 0;

        while(i<=m && j<=r){
            if(nums[j].val < nums[i].val){
                temp[k++] = nums[j++];
                rightCount++;
            }else{
                res[nums[i].idx] += rightCount;
                temp[k++] = nums[i++];
            }
        }

        while(i<=m){
            res[nums[i].idx] += rightCount;
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