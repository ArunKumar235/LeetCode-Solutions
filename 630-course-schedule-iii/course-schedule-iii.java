class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<int[]> maxh = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        int days = 0;

        for(int[] course : courses){
            if (course[0] > course[1]) continue;

            days += course[0];

            if(days > course[1]){
                int[] longestCourse = maxh.peek();

                if(longestCourse[0] >= course[0]){
                    maxh.poll();
                    days -= longestCourse[0];
                    maxh.add(course);
                }else{
                    days -= course[0];
                }
            }else{
                maxh.add(course);
            }
        }
        return maxh.size();
    }
}