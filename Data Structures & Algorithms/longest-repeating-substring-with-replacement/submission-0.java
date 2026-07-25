class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int maxfreq=0;
        int maxWinSize=0;

      for(int right=0, left=0; right<s.length(); right++){
         //update freq
        freq[s.charAt(right)-'A']++;
        //update maxfreq
        maxfreq=Math.max(maxfreq, freq[s.charAt(right)-'A']);
        int winSize=right-left+1;
        //number of chars that need to be changed must be from least freq elem
        //=winSize-maxfreq
        if(winSize-maxfreq>k){
            freq[s.charAt(left)-'A']--;
            left++;
            //updated winsize
            winSize=right-left+1;
        }
        maxWinSize=Math.max(maxWinSize,winSize);
      }
      return maxWinSize;
    }
}
