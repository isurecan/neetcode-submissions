class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
       
        for(int i=0; i<rows; i++){
            if(target<=matrix[i][columns-1]){
               if (binarySearch(matrix[i], target))
               return true;
               else return false;
            }
        }
        return false;
    }

        public boolean binarySearch(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
       while(start<=end){
        int mid=(start+end)/2;
        //use start+(end-start)/2 to avoid integer overflow
        if(target>nums[mid]){
            start=mid+1;
        }
        else if(target<nums[mid]){
            end=mid-1;
        }
        else
        return true;
       }
        return false;
    }

}
