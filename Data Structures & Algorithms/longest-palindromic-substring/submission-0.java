class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            int left=i;
            int right=i;
            char c=s.charAt(i);

            while(left>=0 && c==s.charAt(left))
            left--;

            while(right<n && c==s.charAt(right))
            right++;

            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right))
                break;
                else
                left--;
                right++;
            }

            if(end-start<right-left+1)
            {
                start=left;
                end=right;
            }
        }
        return s.substring(start+1, end);
    }
}
