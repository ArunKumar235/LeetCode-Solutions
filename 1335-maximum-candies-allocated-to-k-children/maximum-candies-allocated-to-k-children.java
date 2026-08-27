class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        for(int candy: candies) total += candy;

        if(total < k) return 0;

        long l = 1;
        long r = total / k;
        while(l <= r){
            long mid = l + (r-l) / 2;
            if(check(candies, k, mid)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return (int) r;
    }

    private boolean check(int[] candies, long k, long perPerson){
        long childs = 0;
        for(int candy: candies){
            childs += candy / perPerson;
            if(childs >= k) return true;
        }
        return false;
    }
}