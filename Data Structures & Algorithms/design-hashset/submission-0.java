class MyHashSet {
    private static final int SIZE = 10007; // Prime number for good distribution
    private ListNode[] table;
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    public MyHashSet() {
        table = new ListNode[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        ListNode node = table[index];
        
        while (node != null) {
            if (node.val == key) {
                return; 
            }
            node = node.next;
        }
        
        ListNode newNode = new ListNode(key);
        newNode.next = table[index];
        table[index] = newNode;
    }
    
    public void remove(int key) {
        int index = hash(key);
        ListNode node = table[index];
        ListNode prev = null;
        
        while (node != null) {
            if (node.val == key) {
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
    
    public boolean contains(int key) {
        int index = hash(key);
        ListNode node = table[index];
        
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}