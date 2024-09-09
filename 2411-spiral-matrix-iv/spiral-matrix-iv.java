/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        int x = 1;
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        for(int i = 0; i<m; i++){
            Arrays.fill(mat[i], -1);    
        }
        while(left<=right && top<=bottom){
            for(int i = left; i<=right; i++){
                if(head!=null){
                    mat[top][i] = head.val;
                    head = head.next;
                }else{
                    break;
                } 
            }
            top++;
            for(int i = top; i<=bottom; i++){
                if(head!=null){
                    mat[i][right] = head.val;
                    head = head.next;
                }else{
                    break;
                }
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    if(head!=null){
                        mat[bottom][i] = head.val; 
                        head = head.next;   
                    }else{
                        break;
                    }
                }
                bottom--;
            }if(left<=right){
                for(int i = bottom; i>=top; i--){
                    if(head!=null){
                        mat[i][left] = head.val; 
                        head = head.next;   
                    }else{
                        break;
                    }
                }
                left++;
            }
        }
        return mat;
    }
}