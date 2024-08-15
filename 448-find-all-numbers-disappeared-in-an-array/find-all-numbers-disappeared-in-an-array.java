class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(i+1 != nums[i] && !li.contains(i+1)){
                li.add(i+1);
            }
        }
        return li;
    }

    public void sort(int[] arr, int n){
        int i = 0;
        while(i<n){
            int j = arr[i] -1;
            if(j<n && arr[j] != arr[i]){
                swap(arr,i,j);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}