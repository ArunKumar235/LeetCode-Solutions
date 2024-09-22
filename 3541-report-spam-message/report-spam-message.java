class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> b = new HashSet<>(Arrays.asList(bannedWords));
        int x = 0;
        for(String i: message){
            if(b.contains(i)){
                x++;
                if(x==2){
                    return true;
                }
            }
        }
        return false;
    }
}