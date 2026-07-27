class Solution {
    public void rotate(int[][] matrix) {
      //transpose->reverse row
      //transpose=swap across main diagonal
      //reverse row=swap lefts and rights
      for(int i=0; i<matrix.length; i++){
        for(int j=i+1; j<matrix.length; j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
      } 
    for(int i=0; i<matrix.length; i++){
        int left=0;
        int right=matrix.length-1;
        while(left<right){
            int temp=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=temp;
            left++;
            right--;
        }
    } 
    }
}
