class Solution {
    String num;
    int target;
    List<String> res;
    
    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        this.res = new ArrayList<>();

        func(0, new StringBuilder(), 0, 0);

        return res;
    }

    private void func(int idx, StringBuilder exp, long value, long prev){
        if(idx == num.length()){
            if(value == target) res.add(exp.toString());
            return;
        }
        
        for(int end = idx; end < num.length(); end++){
            // leading zeros are invalid
            if(end > idx && num.charAt(idx) == '0') break;

            long curr = Long.parseLong(num.substring(idx, end + 1));

            int len = exp.length();

            if(idx == 0){
                exp.append(curr);
                func(end+1, exp, curr, curr);
                exp.setLength(len);

            }else{
                // add
                exp.append("+").append(curr);
                func(end+1, exp, value+curr, curr);
                exp.setLength(len);

                // sub
                exp.append("-").append(curr);
                func(end+1, exp, value-curr, -curr);
                exp.setLength(len);

                // mul 
                long newValue = (value - prev) + (prev * curr);
                exp.append("*").append(curr);
                func(end+1, exp, newValue, prev * curr);
                exp.setLength(len);
            }
        }
    }
}