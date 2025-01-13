class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int res = 0;
        for(int freq: map.values()){
            if(freq!=0 && freq%2==0){
                res+=2;
            }else{
                res+=1;
            }
        }
        return res;
    }
}