class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colbegin=0;
        int colend=matrix[0].length-1;
        int rowbegin=0;
        int rowend=matrix.length-1;
        List<Integer> res=new ArrayList<>();
        while(rowbegin<=rowend && colbegin<=colend){
            //traverse right
            for(int j=colbegin; j<=colend; j++){
                res.add(matrix[rowbegin][j]);
            }
            rowbegin++;

            //traverse down
            for(int j=rowbegin; j<=rowend; j++){
                res.add(matrix[j][colend]);
            }
            colend--;

            //traverse left
            //**boundary check is imp to avoid duplicate**
            if (rowbegin <= rowend)
            for(int j=colend; j>=colbegin; j--){
                res.add(matrix[rowend][j]);
            }
            rowend--;

            //traverse up
            //**boundary check is imp to avoid duplicate**
            if (colbegin <= colend)
            for(int j=rowend; j>=rowbegin; j--){
                res.add(matrix[j][colbegin]);
            }
            colbegin++;
        }
        return res;
    }
}
