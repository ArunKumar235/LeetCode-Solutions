class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int top = 0;
	    int bottom = mat.length -1;
	    int left = 0;
	    int right = mat[0].length -1;
	    List<Integer> li = new ArrayList<>();
	    
	    while(top<=bottom && left<=right){
	        for(int i = left; i<=right; i++){
	            li.add(mat[top][i]);
	        }
	        top++;
	        for(int i = top; i<=bottom; i++){
	            li.add(mat[i][right]);
	        }
	        right--;
	        if(top<=bottom){
	            for(int i = right; i>=left; i--){
	                li.add(mat[bottom][i]);
	            }
	            bottom--;
	        }
	        if(left<=right){
	            for(int i = bottom; i>=top; i--){
	                li.add(mat[i][left]);
	            }
	            left++;
	        }
	    }
        return li;
    }
}