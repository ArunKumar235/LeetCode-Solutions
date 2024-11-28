class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = -1;
        int ele2 = -1;
        int c1 = 0;
        int c2 = 0;
        for(int num: nums){
            if(ele1==num) c1++;
            else if(ele2==num) c2++;
            else if(c1==0){
                ele1 = num;
                c1 = 1;
            }else if(c2==0){
                ele2 = num;
                c2 = 1;
            }else{
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for(int num: nums){
            if(ele1==num) c1++;
            else if(ele2==num) c2++;
        }
        List<Integer> res = new ArrayList<>();
        if(c1>n/3) res.add(ele1);
        if(c2>n/3) res.add(ele2);

        return res;
    }
}