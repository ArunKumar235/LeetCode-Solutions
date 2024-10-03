class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateCombinations(digits, 0, sb, result, map);
        return result;
    }

    public void generateCombinations(String digits, int index, StringBuilder sb, List<String> result, HashMap<Character, String> map){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return ;
        }
        char d = digits.charAt(index);
        String val = map.get(d);
        for(int i = 0; i<val.length(); i++){
            sb.append(val.charAt(i));
            generateCombinations(digits, index+1, sb, result, map);
            sb.setLength(sb.length()-1);
        }
    }
}