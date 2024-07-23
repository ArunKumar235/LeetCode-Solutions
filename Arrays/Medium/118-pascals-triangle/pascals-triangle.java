/*
result[i][j] = result[i-1][j-1] + result[i-1][j]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            result.add(currentRow);
            for(int j=1; j<=i; j++){
                if (i==j){
                    result.get(i).add(1);
                }else{
                    int c = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    result.get(i).add(c);
                }

            }
        }
        return result;
    }
}