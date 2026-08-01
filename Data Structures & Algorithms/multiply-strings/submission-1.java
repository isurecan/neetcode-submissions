class Solution {
    public String multiply(String num1, String num2) {
        
        if(num1.equals("0")||num2.equals("0"))
        return "0";

        //max prd length =n1+n2 (ex: 99*99=9801=4 digits)
        int[] res=new int[num1.length()+num2.length()];

        for(int i=num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                int d1=num1.charAt(i)-'0';
                int d2=num2.charAt(j)-'0';
                int prd=d1*d2;

                int sum=res[i+j+1]+prd;
                res[i+j+1]=sum%10;
                //carry forward
                //accumulate carry
                res[i+j]+=sum/10;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int num: res){
            //remove leading zeros
            if(!(sb.length()==0 && num==0))
            sb.append(num);
        }
        return sb.toString();
    }
}
