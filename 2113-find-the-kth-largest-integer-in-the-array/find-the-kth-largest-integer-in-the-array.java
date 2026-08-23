class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> check(a, b));
        
        for(String num : nums){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    private int check(String a, String b) {
        if (a.length() != b.length()) {
            return Integer.compare(a.length(), b.length());
        }

        return a.compareTo(b);
    }
}