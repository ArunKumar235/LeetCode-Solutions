class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int freeDays = 0;
        int lastDay = 0;

        for(int[] meet: meetings){
            int start = meet[0];
            int end = meet[1];

            if(start > lastDay) freeDays += start - lastDay - 1;

            lastDay = Math.max(lastDay, end);
        }
        freeDays += days - lastDay;

        return freeDays;
    }
}