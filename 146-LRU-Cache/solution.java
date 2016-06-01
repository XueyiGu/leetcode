class Node
{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
    }
    
    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            addToHead(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.key);
                remove(tail);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }
    
    private void remove(Node node){
        if(node.pre == null){
            head = node.next;
            if(head != null){
                head.pre = null;
            }
        }else{
            node.pre.next = node.next;
        }
        
        if(node.next == null){
            tail = node.pre;
            if(tail != null){
                tail.next = null;
            }
        }else{
            node.next.pre = node.pre;
        }
    }
    
    private void addToHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            head.pre = node;
            node.next = head;
            head = node;
            head.pre = null;
        }
        
    }
    
}