class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        li.add(nums[0]);
        
        for(int i = 1; i<n; i++){
            
            if(li.get(li.size()-1) < nums[i]){
                li.add(nums[i]);
                if(li.size()==3) return true;
            }else{
                int idx = binarySearch(li, nums[i]);
                li.set(idx, nums[i]);
            }

        }
        return false;
    }

    private int binarySearch(List<Integer> li, int val){
        int start = 0;
        int end = li.size()-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(li.get(mid)==val){
                return mid;
            }else if(li.get(mid)<val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}