class Solution {
    long MOD = (long) 1e9 + 7;

    public int maxTotalValue(int[] value, int[] decay, int m) {
        long totalPositives = 0;
        int max = 0;

        for(int i = 0; i < value.length; i++){
            // value - k * decay >= minValue
            if(totalPositives <= m) totalPositives += (value[i] - 1L) / decay[i] + 1;
            max = Math.max(max, value[i]);
        }

        if(totalPositives <= m) return getSum(value, decay, (int) totalPositives, 1);

        int l = 1;
        int r = max;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(check(value, decay, m, mid)){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return getSum(value, decay, m, r);
    }

    private int getSum(int[] value, int[] decay, int m, int minValue){
        long answer = 0;
        int remaining = m;

        for(int i = 0; i < value.length; i++){
            if(value[i] <= minValue) continue;

            // value - k * decay >= minValue
            int count = (value[i] - (minValue + 1)) / decay[i] + 1;

            int first = value[i];
            int last = value[i] - (count - 1) * decay[i];

            answer += (long)count * (first + last) / 2;
            answer %= MOD;

            remaining -= count; 
        }

        answer += (remaining % MOD) * minValue;

        return (int) (answer % MOD);
    }

    private boolean check(int[] value, int[] decay, int m, int minValue){
        int count = 0;

        for(int i = 0; i < value.length; i++){
            if(value[i] < minValue) continue;

            // value - k * decay >= minValue
            count += (value[i] - minValue) / decay[i] + 1;

            if(count >= m) return true;
        }
        return false;
    }
}