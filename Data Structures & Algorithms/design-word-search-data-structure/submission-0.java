class TrieNode{
    boolean isComplete;
    TrieNode[] children;
    TrieNode(){
        isComplete=false;
        children=new TrieNode[26];
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null){
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.isComplete=true;
    }

    public boolean search(String word) {
        TrieNode node=root;
       return dfs(node, 0, word);
    }

    public boolean dfs(TrieNode node, int index, String word){
        if(node==null)
        return false;
        
        if(index==word.length())
        return node.isComplete;

        char c=word.charAt(index);
        if(c!='.')
        {
            if(node.children[c-'a']==null){
                return false;
            }
            return dfs(node.children[c-'a'],index+1, word);
        }
        else{
            for(TrieNode child:node.children){
                if(child!=null){
                    if(dfs(child,index+1, word))
                    return true;
                }
            }
            return false;
        }

    }
}
