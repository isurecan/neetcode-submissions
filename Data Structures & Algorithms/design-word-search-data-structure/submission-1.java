class TrieNode{
    TrieNode[] children;
    boolean isComplete;

    TrieNode(){
        children=new TrieNode[26];
        isComplete=false;
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
        if(node==null) return false;
        if(index==word.length()) return node.isComplete;

        char c=word.charAt(index);
        if(c!='.'){
            if(node.children[c-'a']==null) return false;
            else return dfs(node.children[c-'a'], index+1, word);
        }
        else{
            for(TrieNode child: node.children){
                if(child!=null){ 
//if this child has a refrence then return true
//otherwise keep checking for other child
                    if(dfs(child, index+1, word)) return true;
                }
            }
            return false;
        }
    }

}
