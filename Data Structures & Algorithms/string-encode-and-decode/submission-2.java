class Solution {

    public String encode(List<String> strs) {
        //use length followed by seperator followed by word
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;

            //find length of word which is stored upto seperator
            while(str.charAt(j)!='#'){
            j++;
            }
            int l=Integer.parseInt(str.substring(i,j));

            //extract word
            String word= str.substring(j+1, j+1+l);
            res.add(word);

            //update start index for new block
            i=j+1+l;
        }
        return res;
    }
}
