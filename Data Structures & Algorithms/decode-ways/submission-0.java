class Solution {
    public int numDecodings(String s) {
        int[] ways=new int[s.length()+1];
        //dp[i] representing number of ways to decode if string len was i.
        ways[0]=1;
        //if input string len is 0, then there is only one way=empty;
        ways[1]=s.charAt(0)=='0'? 0:1;

        for(int i=2; i<=s.length(); i++){
            int onedigit=Integer.valueOf(s.substring(i-1,i));
            int twodigit=Integer.valueOf(s.substring(i-2,i));

            if(onedigit>0)
            ways[i]+=ways[i-1];

            if(twodigit>=10 && twodigit<=26)
            ways[i]+=ways[i-2];
        }
        return ways[s.length()];
    }
}
