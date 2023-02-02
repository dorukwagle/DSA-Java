package LinkedList;

import HashTables.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(1, "hello");
        ht.put(2, "hi");
        ht.put(23, "ahi");
        ht.put(3, "mohmmad ka");
        ht.put(8, "safik ka");
        ht.put(13, "cocumber");
        ht.put(18, "potatoes");
        ht.put(20, "muralidhar");
        ht.put(10, "gandakia");
        System.out.println(ht.get(1));
        System.out.println(ht.get(18));
        System.out.println(ht.get(20));
        ht.put(10, "karnali");
        ht.put(2, "lumbini");
        ht.put(20, "kathmandu");
//        ht.put(5, "flka");
        ht.remove(13);
//        ht.remove(20);
        System.out.println(ht.get(10));

        System.out.println(ht.get(2));
//        System.out.println(ht.get(20));
        System.out.println(ht.get(20));
    }
}
