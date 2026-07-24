class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        boolean isSorted = true;
        char prev = arr[0];
        int min = arr[0];
        int max = arr[0];
        for(char ch: arr){
            if(prev > ch) isSorted = false;
            min = Math.min(min, ch);
            max = Math.max(max, ch);
            prev = ch;
        }
        if(isSorted) return 0;

        if(arr.length==2) return -1;

        if(arr[0]==min || arr[arr.length-1]==max) return 1;

        for(int i = 1; i<arr.length-1; i++) if(arr[i]==min || arr[i]==max) return 2;

        if(arr[0]==max && arr[arr.length-1]==min) return 3;

        return -2;
    }
}