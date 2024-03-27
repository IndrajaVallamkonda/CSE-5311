class HashNode {
    int key;
    int value;
    HashNode next;
    HashNode prev;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class HashTable {
    private HashNode[] table;
    private int size;
    private int capacity;
    private static final double increaseFactor = 0.75;
    private static final double decreaseFactor = 0.25;

    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.table = new HashNode[capacity];
    }

    public void printTable(){
        System.out.println();
        System.out.println("Printing hash table:");
        for(int i=0; i< capacity; i++){
            System.out.print("index :" + i + "-----" );
            HashNode current = table[i];
            while (current != null) {
                System.out.print(" -> " + current.key);
                current = current.next;
            }
            System.out.println();
        }
        System.out.println();
    }

    private int hash(int key) {
        double A = (Math.sqrt(5) - 1) / 2; // Multiplication factor
        return ((int) Math.floor(capacity * ((key * A) % 1)));
    }

    public void put(int key, int value) {
        int index = hash(key);
        HashNode newNode = new HashNode(key, value);
        size = size + 1;
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            HashNode current = table[index];
            while (current.next != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        System.out.println("inserted key "  + key + " into table ");
        if ((double) size / capacity >= increaseFactor) {
            resizeTable(capacity * 2);
        }
    }

    public int get(int key) {
        HashNode current = table[hash(key)];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        if(get(key) == -1){
            System.out.println("Key " + key + " not found to delete");
            return;
        }
        System.out.println("deleted key "  + key + " from table ");
        int index = hash(key);
        HashNode current = table[index];
        while (current != null) {
            if (current.key == key) {
                if (current.prev == null) {
                    table[index] = current.next;
                } else {
                    current.prev.next = current.next;
                }
                 size = size - 1;
                if ((double) size / capacity <= decreaseFactor) {
                    resizeTable(capacity / 2);
                }
                return;
            }
            current = current.next;
        }
    }

    private void resizeTable(int newCapacity) {
        HashNode[] newTable = new HashNode[newCapacity];
        int oldCapacity= capacity;
        capacity = newCapacity;
        HashNode current;
        HashNode processing;

        for (int i = 0; i < oldCapacity; i++) {
            current = table[i];
            while (current != null) {
               processing = current;
               current = current.next;
               if(current!= null){
               current.prev= null;
               }
               processing.next = null;
               int newIndex = hash(processing.key);
                if (newTable[newIndex] == null) {
                    newTable[newIndex] = processing;
                } else {
                    HashNode temp = newTable[newIndex];
                    while (temp.next != null) {
                        System.out.println("here");
                        temp = temp.next;
                    }
                    temp.next = processing;
                    processing.prev = temp;
                }
            }
        }
        table = newTable;
        if(oldCapacity > newCapacity){
            System.out.println("table got resized - decreased");
        }else{
            System.out.println("table got resized - increased");
        }

    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(6);
        hashTable.put(5, 100);
        hashTable.put(4, 90);
        hashTable.remove(11);
        hashTable.put(11, 70);
        hashTable.put(66, 30);
        hashTable.put(33, 88);
        hashTable.put(45, 76);
        hashTable.put(54, 88);
        System.out.println("Value for key 33: " + hashTable.get(33));
        hashTable.printTable();
        hashTable.put(18, 81);
        hashTable.put(34, 59);
        hashTable.printTable();
        System.out.println("Value for key 33: " + hashTable.get(33) + " after resizing");
        hashTable.remove(11);
        System.out.println("Value for key 11 after removal: " + hashTable.get(11));
        hashTable.remove(5);
        hashTable.remove(45);
        hashTable.remove(54);
        hashTable.remove(18);
        hashTable.remove(4);
        hashTable.printTable();
    }
}

// Output:-
// inserted key 5 into table 
// inserted key 4 into table 
// Key 11 not found to delete
// inserted key 11 into table 
// inserted key 66 into table 
// inserted key 33 into table 
// table got resized - increased
// inserted key 45 into table 
// inserted key 54 into table 
// Value for key 33: 88

// Printing hash table:
// index :0-----
// index :1----- -> 5
// index :2-----
// index :3-----
// index :4----- -> 33 -> 54
// index :5----- -> 4
// index :6-----
// index :7-----
// index :8-----
// index :9----- -> 11 -> 66 -> 45
// index :10-----
// index :11-----

// inserted key 18 into table 
// inserted key 34 into table 
// table got resized - increased

// Printing hash table:
// index :0----- -> 34
// index :1-----
// index :2----- -> 5 -> 18
// index :3-----
// index :4-----
// index :5-----
// index :6-----
// index :7-----
// index :8----- -> 54
// index :9----- -> 33
// index :10-----
// index :11----- -> 4
// index :12-----
// index :13-----
// index :14-----
// index :15-----
// index :16-----
// index :17-----
// index :18----- -> 66
// index :19----- -> 11 -> 45
// index :20-----
// index :21-----
// index :22-----
// index :23-----

// Value for key 33: 88 after resizing
// deleted key 11 from table 
// Value for key 11 after removal: -1
// deleted key 5 from table 
// deleted key 45 from table 
// table got resized - decreased
// deleted key 54 from table 
// deleted key 18 from table 
// deleted key 4 from table 
// table got resized - decreased

// Printing hash table:
// index :0----- -> 34 -> 18
// index :1-----
// index :2----- -> 33
// index :3-----
// index :4----- -> 66 -> 45
// index :5-----
