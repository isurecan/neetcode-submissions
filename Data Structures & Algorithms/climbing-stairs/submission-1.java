class Solution {
    public int climbStairs(int n) {
        if(n==1)
        return 1;
        
        int[] ways=new int[n+1];
        //for 1step there is only one way
        //for 2 steps there are two ways (1+1, 2)
        ways[1]=1;
        ways[2]=2;
        
        for(int i=3; i<=n; i++){
            ways[i]=ways[i-1]+ways[i-2];
        }

        return ways[n];
    }
}
