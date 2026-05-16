class Solution {
    public int trap(int[] height) {
    int left=0;
    int right=height.length-1;
    int lmax=0;
    int rmax=0;
    int capacity=0;
    while(left<right){
        lmax=Math.max(lmax, height[left]);
        rmax=Math.max(rmax, height[right]);

        if(lmax<rmax){
            capacity+=lmax-height[left];
            left++;
        }
        else{
            capacity+=rmax-height[right];
            right--;
        }
    }
    return capacity;
    }
}
