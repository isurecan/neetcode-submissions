class Solution {
    public int minCostClimbingStairs(int[] cost) {
      //given cost.length>=2
        int n=cost.length;
        int[] mincost=new int[n+1];
        //since i can start from 0 or 1 so cost at 0 and 1 is 0
        mincost[0]=0;
        mincost[1]=0;
        for(int i=2; i<=n; i++){
            mincost[i]=Math.min(mincost[i-1]+cost[i-1]
            ,mincost[i-2]+cost[i-2]);
        }
        return mincost[n];
    }
}
