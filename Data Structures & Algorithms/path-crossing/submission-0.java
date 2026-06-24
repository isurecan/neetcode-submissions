class Solution {
    public boolean isPathCrossing(String path) {
     Set<String> set=new HashSet<>();
     set.add(0+","+0);
    int x=0;
    int y=0;
     for(char c:path.toCharArray()){
        if(c=='N') y++;
        else if (c=='S') y--;
        else if (c=='E') x++;
        else x--;

        if(set.contains(x+","+y)){
            return true;
        }
        else
        set.add(x+","+y);
     }  
     return false; 
    }
}