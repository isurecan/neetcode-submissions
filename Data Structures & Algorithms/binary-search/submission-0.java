class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
       while(start<=end){
        int mid=(start+end)/2;
        if(target>nums[mid]){
            start=mid+1;
        }
        else if(target<nums[mid]){
            end=mid-1;
        }
        else
        return mid;
       }
        return -1;
    }
}
