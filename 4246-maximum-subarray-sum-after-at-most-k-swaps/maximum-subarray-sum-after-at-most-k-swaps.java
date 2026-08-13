class Solution {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;
        
        int negatives = 0;
        for(int num: nums) if(num<0) negatives++;
        
        if(negatives==n){
            int max = nums[0];
            for(int num: nums) max = Math.max(max, num);
            return max;
        }

        if(negatives<=k){
            int sum = 0;
            for(int num: nums) if(0<num) sum += num;
            return sum;
        }
        
        long[] prefix = new long[n];
        for(int i = 0; i<n; i++){
            if(i==0) prefix[0] = nums[0];
            else prefix[i] = prefix[i-1] + nums[i];
        }

        long res = Long.MIN_VALUE;

        for(int l = 0; l<n; l++){
            
            PriorityQueue<Integer> inside = new PriorityQueue<>();
            long insideSum = 0;
            
            long[] remove = new long[n];
            
            for(int r = l; r<n; r++){
                if(nums[r] < 0){
                    insideSum += -nums[r];
                    inside.offer(-nums[r]);
                }
                if(inside.size() > k) insideSum -= inside.poll();

                remove[r] = insideSum;
            }

            PriorityQueue<Integer> outside = new PriorityQueue<>();
            long outsideSum = 0;

            for(int i = 0; i<l; i++){
                if(0 <= nums[i]){
                    outsideSum += nums[i];
                    outside.offer(nums[i]);
                }
                if(outside.size() > k) outsideSum -= outside.poll();
            }

            for(int r = n-1; r>=l; r--){
                long subSum = prefix[r];
                if(l > 0) subSum = prefix[r] - prefix[l-1];

                res = Math.max(
                    res,
                    subSum + remove[r] + outsideSum 
                );

                if(nums[r] >= 0){
                    outsideSum += nums[r];
                    outside.offer(nums[r]);
                }
                if(outside.size() > k) outsideSum -= outside.poll();
            }
        }
        return res;
    }
}