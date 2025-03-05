class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Set<Integer> set = new HashSet<>();
        for(int num: numsDivide){
            set.add(num);
        }
        int gcd = numsDivide[0];
        for(int num: set){
            gcd = findGCD(gcd, num);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            if(gcd%nums[i]==0) min = Math.min(min, nums[i]);
        }   
        if(min==Integer.MAX_VALUE) return -1;
        int res = 0;
        for(int num: nums){
            if(num<min){
                res++;
            }
        }
        return res;
    }

    private int findGCD(int a, int b){
        return (a==0) ? b : findGCD(b%a, a);
    }
}