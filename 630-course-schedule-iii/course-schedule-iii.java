class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int day = 0;

        for(int[] course: courses){
            day += course[0];
            pq.offer(course[0]);

            if(day > course[1]){
                day -= pq.poll();
            }
        }

        return pq.size();
    }
}