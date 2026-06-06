class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=0;

        for(int pile:piles){
            maxSpeed=Math.max(maxSpeed, pile);
        }

        while(minSpeed<maxSpeed){
            int mid= minSpeed+(maxSpeed-minSpeed)/2;

            if(kokoCanEat(mid, piles, h))
            maxSpeed=mid;
            else 
            minSpeed=mid+1;
        }
        return minSpeed;
    }

    private boolean kokoCanEat(int mid, int[] piles, int h){
        int hrs=0;
        for(int num:piles){
           // hrs += (int) Math.ceil((double) num / mid);
            //force floating point division
           // even better trick, avoids avoids floating-point arithmetic entirely. 
           hrs+= (num+mid-1)/mid;
        }
        if(hrs<=h) return true;
        else return false;
    }
}
