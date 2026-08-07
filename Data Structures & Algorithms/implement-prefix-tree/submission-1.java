class TrieNode{
    TrieNode[] children;
    boolean isComplete;

    TrieNode(){
        children=new TrieNode[26];
         isComplete =false;
    }

    }
    
    class PrefixTree {
TrieNode root;

    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
TrieNode node=root;
for(char c: word.toCharArray()){
    if(node.children[c-'a']==null){
        node.children[c-'a']= new TrieNode();
    }
node=node.children[c-'a'];
}
  node.isComplete=true;  }

    public boolean search(String word) {
TrieNode node=root;
for(char c:word.toCharArray()){
    if(node.children[c-'a']==null)
    return false;
    node=node.children[c-'a'];

}
return node.isComplete ;
    }

    public boolean startsWith(String prefix) {
TrieNode node=root;
for(char c: prefix.toCharArray()){
    if(node.children[c-'a']==null)
    return false;
    node=node.children[c-'a'];
}return true;
    }
}
