class Solution {
    public int maxArea(int[] heights) {
        
    int capacity=0;
    int left=0;
    int right=heights.length-1;

//im trying to find the prd= min of two*diff of index, and keep on storing the max;

        while(left<right){
           int prd=Math.min(heights[left],heights[right])*(right-left); 
           capacity=Math.max(capacity,prd);
           if(heights[right]<heights[left]) right--;
           else left++; 
        }

        return capacity;

    }
}
