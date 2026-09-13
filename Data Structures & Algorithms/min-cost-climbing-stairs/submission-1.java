class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mincost =new int[cost.length+1];
        if(cost.length<2)
        return 0;

        mincost[0]=0;
        mincost[1]=0;

        for(int i=2; i<cost.length+1; i++){
            int a= mincost[i-2]+cost[i-2];
            int b= mincost[i-1]+cost[i-1];
            mincost[i]=Math.min(a,b);
        }
        return mincost[cost.length];
    }
}
