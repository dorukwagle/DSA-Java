package structures.HashTables;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] array;

    public HashTable(int initialCapacity){
        array = new LinkedList[initialCapacity];
    }

    public HashTable(){
        this(100);
    }

    public void put(int k, String v) {
        int index = hash(k);
        if(array[index] == null)
            array[index] = new LinkedList<>();

        var entry = getEntry(k);
        if (entry != null)
            entry.value = v;
        array[index].addLast(new Entry(k, v));
    }

    public String get(int key){
        var entry = getEntry(key);
        if (entry != null)
            return entry.value;
        throw new NoSuchElementException();
    }

    public void remove(int key){
        var list = getList(key);
        var entry = getEntry(key);
        if ( list != null && entry != null) {
            list.remove(entry);
            return;
        }
        throw new NoSuchElementException();
    }

    private LinkedList<Entry> getList(int key){
        return array[hash(key)];
    }

    private Entry getEntry(int key){
        var list = getList(key);
        if (list != null) {
            for (var entry : list) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private boolean isNull(int index){
        return array[index] == null;
    }

    private int hash(int key){
        return Math.abs(key) % array.length;
    }

}
