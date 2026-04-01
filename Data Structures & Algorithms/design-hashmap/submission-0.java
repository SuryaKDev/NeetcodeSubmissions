class MyHashMap {
    private static final int SIZE = 10007;
    private ListNode[] table;

    private class ListNode {
        int key; 
        int val;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        table = new ListNode[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int val) {
        int index = hash(key);
        ListNode node = table[index];
        while (node != null) {
            if (node.key == key) {
                node.val = val;
                return;
            }
            node = node.next;    
        }
        ListNode newNode = new ListNode(key, val);
        newNode.next = table[index];     
        table[index] = newNode;
    }
    
    public int get(int key) {
        int index = hash(key);
        ListNode node = table[index];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;    
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);       
        ListNode node = table[index];
        ListNode prev = null;
    
        while (node != null) {
            if (node.key == key) {   
                if (prev == null) {  
                    table[index] = node.next;  
                } else {             
                    prev.next = node.next;     
                }
                return;              
            }
            prev = node;            
            node = node.next;
        }
    
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */