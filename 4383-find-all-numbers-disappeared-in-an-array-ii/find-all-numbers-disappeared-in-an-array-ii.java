class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        boolean[] isAvail = new boolean[upper+1];

        for(int num: nums) if(num <= upper) isAvail[num] = true;

        List<List<Integer>> res = new ArrayList<>();

        int l = lower;

        while(l <= upper){
            if(!isAvail[l]){
                int r = l;

                while(r <= upper && !isAvail[r]) r++;

                res.add(Arrays.asList(l, r-1));
                
                l = r;
            }else{
                l++;
            }
        }
        return res;
    }
}