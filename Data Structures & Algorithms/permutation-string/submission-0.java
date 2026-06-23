class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
        return false;

        int[] freq=new int[26];
        int[] windowFreq=new int[26];

//build the og freq array; 
//and build the first window;
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
            windowFreq[s2.charAt(i)-'a']++;
        }
//check the first window
    if(freqSame(freq,windowFreq))
    return true;

//otherwise, slide the window
//since we already checked for s1.length iterations, we begin after that
//in each new window a char from left is decreased and right is increased
for(int right=s1.length(); right<s2.length(); right++){
    int left=right-s1.length(); //since, windowlength=right-left

    //remove left char
    windowFreq[s2.charAt(left)-'a']--;
    //add right char
    windowFreq[s2.charAt(right)-'a']++;

    if(freqSame(freq,windowFreq)){
        return true;
    }

}
return false;
    }

   public boolean freqSame(int[] a1, int[] a2){
    for(int i=0; i<26; i++){
        if(a1[i]!=a2[i]){
            return false;
        }
       
    }
     return true;
   }

}
