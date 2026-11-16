class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int res = 0;
        int currX = Integer.MIN_VALUE;
        for(int[] pair: pairs){
            if(currX < pair[0]){
                res++;
                currX = Math.max(currX, pair[1]);
            }
        }
        return res;
    }
}
// pairs = [[1, 10], [2, 3], [4, 5]]

// If we sort by start time, the order is:
// [1, 10] -> [2, 3] -> [4, 5]
// res = 1 (1, 10)

// Instead, sort by end time:
// [2, 3] -> [4, 5] -> [1, 10]
// res = 2 (2, 3)(4, 5)

// Because finishing earlier leaves more room to select future pairs.