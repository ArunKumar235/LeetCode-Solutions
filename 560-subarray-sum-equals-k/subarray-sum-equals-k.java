class Solution {
    public int subarraySum(int[] arr, int K) {
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i<N; i++){
            prefixSum+=arr[i];
            if(map.containsKey(prefixSum-K)){
                count+=map.get(prefixSum-K);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }
}