/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length() - 1;
        int peak = findPeak(0, len, mountainArr);
        int ans = binarySearch(0,peak,mountainArr, target);
        return (ans != -1) ? ans : agonisticBinarySearch(peak,len,mountainArr, target);
    }

    public int findPeak(int start, int end, MountainArray mountainArr){

        while(start<end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)) start = mid+1;
            else end = mid;
        }
        return end;
    }
    
    public int binarySearch(int start, int end, MountainArray mountainArr, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) == target) return mid;
            if(mountainArr.get(mid)<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public int agonisticBinarySearch(int start, int end, MountainArray mountainArr, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid)==target) return mid;
            if(mountainArr.get(mid)<target) end = mid-1;
            else start = mid + 1;
        }
        return -1;
    }
}