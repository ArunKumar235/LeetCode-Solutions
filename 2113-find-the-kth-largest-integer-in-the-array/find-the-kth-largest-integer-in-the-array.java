class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> check(a, b));
        return nums[nums.length - k];
    }
    
    private int check(String a, String b){
        int i = 0;
        int j = 0;
        while(i < a.length() && a.charAt(i)==0) i++;
        while(j < b.length() && b.charAt(j)==0) j++;

        if(a.length()-i < b.length()-j) return -1;
        else if(a.length()-i > b.length()-j) return 1;
        
        while(i<a.length()){
            if(a.charAt(i) < b.charAt(j)) return -1;
            if(b.charAt(j) < a.charAt(i)) return 1;
            i++;
            j++;
        }
        return 0;
    }
}