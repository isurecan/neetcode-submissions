class Solution {
    public String minWindow(String s, String t) {
        //ASCII of A-Z=65-90
        //ASCII of a-z=97-122
        //and we're aiming to store freq at their ASCII index
        //so min size we can use is 123, but can go with standard 128
        int[] freqS=new int[128];
        int[] freqT=new int[128];
        int minLength=Integer.MAX_VALUE;
        int minStart=0;
        //build freqT
        for(char c: t.toCharArray()){
            freqT[c]++;
        }

        for(int right=0, left=0; right<s.length(); right++){
            freqS[s.charAt(right)]++;

            while(freqMatches(freqT,freqS)){
                int winSize=right-left+1;
                if(winSize<minLength){
                     minLength=winSize;
                     minStart=left;
                }
                freqS[s.charAt(left)]--;
                left++;
            }  
        }
      if(minLength!=Integer.MAX_VALUE)
      return s.substring(minStart,minStart+minLength);
      else
      return "";
    }

    public boolean freqMatches(int[] freqT, int[] freqS){
        for(int i=0; i<128; i++){
            if(freqT[i]>freqS[i])
            return false;
        }
        return true;
    }
}
