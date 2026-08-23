class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        mergeSort(0, nums.length-1, nums);
        
        return nums[nums.length - k];
    }

    private void mergeSort(int l, int r, String[] nums){
        if(l >= r) return;
        
        int mid = l + (r-l)/2;
        mergeSort(l, mid, nums);
        mergeSort(mid+1, r, nums);

        merge(l, r, nums);
    }

    private void merge(int l, int r, String[] nums){
        String[] res = new String[r - l + 1];
        int mid = l + (r-l)/2;

        int i = l;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= r){
            if(check(nums[i], nums[j]) <= 0){
                res[k++] = nums[i++];
            }else{
                res[k++] = nums[j++];
            }
        }
        while(i <= mid) res[k++] = nums[i++];
        while(j <= r) res[k++] = nums[j++];

        for(String val: res) nums[l++] = val;
    }
    
    private int check(String a, String b) {
        int i = 0;
        int j = 0;

        while (i < a.length() - 1 && a.charAt(i) == '0') i++;
        while (j < b.length() - 1 && b.charAt(j) == '0') j++;

        int lenA = a.length() - i;
        int lenB = b.length() - j;

        if (lenA < lenB) return -1;
        if (lenA > lenB) return 1;

        while (i < a.length()) {
            if(a.charAt(i) < b.charAt(j)) return -1;
            if(a.charAt(i) > b.charAt(j)) return 1;

            i++;
            j++;
        }
        return 0;
    }
}