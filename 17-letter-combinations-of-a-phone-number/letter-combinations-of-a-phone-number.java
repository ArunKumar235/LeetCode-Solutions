class Solution {
    public List<String> letterCombinations(String digits) {
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
        if(digits.isEmpty()){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        solve(digits, 0, sb, result, map);
        return result;
    }

    public void solve(String digits, int index, StringBuilder sb, List<String> result, HashMap<Character, String> map){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        String rep = map.get(ch);
        for(int i = 0; i<rep.length(); i++){
            sb.append(rep.charAt(i));
            solve(digits, index+1, sb, result, map);
            sb.setLength(sb.length()-1);
        }


    }
}