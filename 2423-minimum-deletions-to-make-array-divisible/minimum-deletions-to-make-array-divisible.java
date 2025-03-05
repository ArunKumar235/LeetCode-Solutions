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
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if(gcd%nums[i]==0) return i;
        }   
        return -1;
    }

    private int findGCD(int a, int b){
        return (a==0) ? b : findGCD(b%a, a);
    }
}