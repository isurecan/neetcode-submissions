class Solution {
    public int hammingWeight(int n) {

        int count=0;

        //since in java there is no unsigned integer
        //so preceeeding one can be trated as negative 
        //so we do not check for n<0
    while(n!=0){
        count+=n&1; 
        //ex: 1011 & 0001 gives 1, 1010 & 0001 gives 0
        //ie. it is essentially checking the last bit 
        //so count increments 1 if bit is 1
        n>>>=1;
        //since we've checked for the last bit, 
        //we need to bitwise moove to the right
        //so 1011>>>=1 becomes 101 
        }

    return count;
    }
}
