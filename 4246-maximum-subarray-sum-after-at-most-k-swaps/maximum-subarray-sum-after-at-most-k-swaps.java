class Solution {
    public long maxSum(int[] nums, int k) {
        int n = nums.length;

        int negatives = 0;
        for(int num : nums){
            if(num < 0) negatives++;
        }

        if(negatives == n){
            int max = nums[0];
            for(int num : nums){
                max = Math.max(max, num);
            }
            return max;
        }

        if(negatives <= k){
            long sum = 0;
            for(int num : nums){
                if(num >= 0) sum += num;
            }
            return sum;
        }

        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long res = Long.MIN_VALUE;

        long[] remove = new long[n];

        for(int l = 0; l < n; l++){

            PriorityQueue<Integer> inside = new PriorityQueue<>();
            long insideSum = 0;

            for(int r = l; r < n; r++){
                if(nums[r] < 0){
                    inside.offer(-nums[r]);
                    insideSum += -nums[r];

                    if(inside.size() > k){
                        insideSum -= inside.poll();
                    }
                }
                remove[r] = insideSum;
            }

            PriorityQueue<Integer> outside = new PriorityQueue<>();
            long outsideSum = 0;

            for(int i = 0; i < l; i++){
                if(nums[i] >= 0){
                    outside.offer(nums[i]);
                    outsideSum += nums[i];

                    if(outside.size() > k){
                        outsideSum -= outside.poll();
                    }
                }
            }

            for(int r = n - 1; r >= l; r--){

                long subSum = prefix[r+1] - prefix[l];

                res = Math.max(
                    res,
                    subSum + remove[r] + outsideSum
                );

                if(nums[r] >= 0){
                    outside.offer(nums[r]);
                    outsideSum += nums[r];

                    if(outside.size() > k){
                        outsideSum -= outside.poll();
                    }
                }
            }
        }

        return res;
    }
}