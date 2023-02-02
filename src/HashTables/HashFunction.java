package HashTables;

public class HashFunction {
    private int initialCapacity;

    public HashFunction(int initialCapacity){
        this.initialCapacity = initialCapacity;
    }

    public int hash(int key){
        return key % initialCapacity;
    }

    public int hash(String key){
        int hash = 0;
        for(var ch: key.toCharArray())
            hash += ch;
        return hash % initialCapacity;
    }

}
