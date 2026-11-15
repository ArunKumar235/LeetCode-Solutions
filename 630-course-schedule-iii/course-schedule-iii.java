class Solution {
    public int scheduleCourse(int[][] courses) {
        // sort by last day asc
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // remove course with highest duration in O(1)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int res = 0;
        int totalDuration = 0;
        for(int[] course: courses){
            int duration = course[0];
            int lastDay = course[1];

            totalDuration += duration;
            maxHeap.offer(duration);

            if(lastDay < totalDuration){
                totalDuration -= maxHeap.poll();
            }
            res = Math.max(res, maxHeap.size());
        }
        return res;
    }
}