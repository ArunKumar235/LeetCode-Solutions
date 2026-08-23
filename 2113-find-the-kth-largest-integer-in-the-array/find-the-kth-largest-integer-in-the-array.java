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
        int i = 0;
        int j = 0;

        while (i < a.length() - 1 && a.charAt(i) == '0') i++;
        while (j < b.length() - 1 && b.charAt(j) == '0') j++;

        int lenA = a.length() - i;
        int lenB = b.length() - j;

        if (lenA < lenB) return -1;
        if (lenA > lenB) return 1;

        while (i < a.length()) {
            if(a.charAt(i) < b.charAt(j)) return -1;
            if(a.charAt(i) > b.charAt(j)) return 1;

            i++;
            j++;
        }
        return 0;
    }
}