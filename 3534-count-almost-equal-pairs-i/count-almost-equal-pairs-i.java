public class Solution {
    public int countPairs(int[] nums) {
        int length = nums.length;
        int pairCount = 0;
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (areAlmostEqual(nums[i], nums[j])) {
                    pairCount++;
                }
            }
        }
        
        return pairCount;
    }

    private boolean areAlmostEqual(int num1, int num2) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        
        while (str1.length() < str2.length()) {
            str1 = "0" + str1;
        }
        while (str2.length() < str1.length()) {
            str2 = "0" + str2;
        }

        int mismatchCount = 0;
        List<Integer> mismatchIndices = new ArrayList<>();
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                mismatchCount++;
                mismatchIndices.add(i);
                if (mismatchCount > 2) {
                    return false;
                }
            }
        }
        
        if (mismatchCount == 0) {
            return true;
        }
        if (mismatchCount == 2) {
            char[] str1Array = str1.toCharArray();
            int indexA = mismatchIndices.get(0);
            int indexB = mismatchIndices.get(1);

            char temp = str1Array[indexA];
            str1Array[indexA] = str1Array[indexB];
            str1Array[indexB] = temp;

            return String.valueOf(str1Array).equals(str2);
        }
        
        return false;
    }
}