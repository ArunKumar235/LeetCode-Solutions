class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        // sort by profit desc
        Arrays.sort(items, (a, b) -> Integer.compare(b[0], a[0]));

        // minHeap to remove lowest profits from each categoy
        PriorityQueue<Integer> duplicates = new PriorityQueue<>();

        Set<Integer> categories = new HashSet<>();

        long total = 0;

        // Phase 1: Select the k highest-profit items
        for(int i = 0; i < k; i++){
            int p = items[i][0];
            int c = items[i][1];
            total += p;
            if(!categories.contains(c)) categories.add(c);
            else duplicates.offer(p);
        }

        long res = total + 1L * categories.size() * categories.size();

        // Phase 2: Try to increase distinct categories and 
        // remove lower profit from duplicate categories
        for(int i = k; i < items.length; i++){
            int p = items[i][0];
            int c = items[i][1];
            if(categories.contains(c) || duplicates.isEmpty()) continue;

            total += p;
            categories.add(c);

            total -= duplicates.poll();

            res = Math.max(res, total + 1L * categories.size() * categories.size());
        }
        return res;
    }
}
