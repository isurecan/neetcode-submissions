//need nodes that contauns not just value, but key, next and prev too.

class Node{
    int key, val;
    Node next, prev;

    Node(int key, int val){
        this.key=key;
        this.val=val;
    }

}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    private void remove (Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;

//we can leave it even after performing the above two steps, but just for understanding
//lets say we detach node completely
        node.next=null;
        node.prev=null;
    }
//maintain dummy head and tail so as initially HEAD ⇄ TAIL
    private void insert(Node node){
        node.prev=tail.prev;
        node.next=tail;
        tail.prev.next=node;
        tail.prev=node;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insert(node);
            return;
        }
        Node node=new Node(key, value);
        insert(node);
        map.put(key, node);

        if(map.size()>capacity){
            Node lru=head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
