class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        HashSet<String> dict=new HashSet<>(Arrays.asList(dictionary));
        return findextra(dict, s,0, dp);
    }

    public int findextra(HashSet<String> dict, String s, int index, int[] dp){
        if(index==s.length())
        return 0;

        if(dp[index]!=-1)
        return dp[index];

        int minExtraChar=Integer.MAX_VALUE;
        StringBuilder sb=new StringBuilder();

        for(int i=index; i<s.length(); i++){
            sb.append(s.charAt(i));
            int extraChar=0;
            if(!dict.contains(sb.toString())){
                extraChar=sb.length(); //**diff from standard, but still works as we're    exploring all variants
            }
            int recurExtraChar=findextra(dict, s, i+1, dp);
            int totalExtraCharAtCurrent=extraChar+recurExtraChar;
            minExtraChar=Math.min(minExtraChar,totalExtraCharAtCurrent);
        }
        dp[index]=minExtraChar;
        return minExtraChar;
    }
}