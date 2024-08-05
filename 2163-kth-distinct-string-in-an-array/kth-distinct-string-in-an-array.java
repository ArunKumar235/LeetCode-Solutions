class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        for(String i: arr){
            if(set.contains(i)){
                dup.add(i);
            }else{
                set.add(i);
            }
        }
        int x = 0;
        for(String i: arr){
            if(! dup.contains(i)){
                x++;
            }  
            if(x==k){
                return i;
            }          
        }
        return "";
    }
}