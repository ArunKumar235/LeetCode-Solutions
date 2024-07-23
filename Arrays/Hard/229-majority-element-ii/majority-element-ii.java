class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        //Initialize the count
        int cnt1 = 0;
        int cnt2 = 0;
        //Initialize the elements to track
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        //Applying the extended version of the algorithm of >n/2 question
        //in case having trouble visit that once to understand it properly
        for(int i=0; i<n; i++){
            if(cnt1==0 && ele2 != nums[i]){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2==0 && ele1 != nums[i]){
                cnt2 = 1;
                ele2 = nums[i];
            }
            else if(nums[i] == ele1) cnt1++;
            else if(nums[i] == ele2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> list = new ArrayList<>(); //List of Answers

        //Manually check if the storedelements in ele1 and ele2 
        //are the majority element:
        cnt1 = 0;
        cnt2 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == ele1) cnt1++;
            if(nums[i] == ele2) cnt2++;
        }

        int min = (int)(n/3) + 1; //min majority element nikalne ke liye
        if(cnt1>=min) list.add(ele1);
        if(cnt2>=min) list.add(ele2);

        return list;
    }
}