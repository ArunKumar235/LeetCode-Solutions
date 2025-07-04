class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows>=s.length())
            return s;

        List<List<Character>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++)
            list.add(new ArrayList<>());

        int row = 0; int index = 0;

        while(index < s.length()){
            for(row = 0; row < numRows && index < s.length(); row++){
                list.get(row).add(s.charAt(index++));
            }
            
            for(row = row-2; row >0 && index < s.length(); row--){
                list.get(row).add(s.charAt(index++));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(List<Character> l : list){
            for(char ch : l){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}