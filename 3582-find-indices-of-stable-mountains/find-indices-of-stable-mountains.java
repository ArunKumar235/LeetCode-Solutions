class Solution {
    public List<Integer> stableMountains(int[] height, int th) {
        List<Integer> li = new ArrayList<>();
        for(int i = 1; i<height.length; i++){
            if(height[i-1]>th){
                li.add(i);
            }
        }
        return li;
    }
}