package Array;

public class Array {
    private int initialSize;
    private int[] array;
    private int elementSize;

    public Array(){
        this.initialSize = 5;
        this.array = new int[this.initialSize];
        this.elementSize = 0;
    }

    public void insert(int number){
        if (initialSize == array.length)
            this.increaseSize();
        array[elementSize++] = number;
    }

    public void removeAt(int index){
        if ( index < 0 || index >= elementSize)
            throw new IllegalArgumentException("Invalid array index supplied");
        array[index] = 0;
        for(int i=index; i<elementSize; ++i)
            array[i] = array[i+1];
        elementSize--;
//        check if the array is too large and shrink it to save some memory
        if(array.length > 3 * elementSize)
            this.shrinkArray();
    }

    private void increaseSize(){
        initialSize += 5;
        int[] temp = new int[initialSize];

        for(int i=0; i<elementSize; ++i)
            temp[i] = this.array[i];

        this.array = temp;
    }

    private void shrinkArray(){
        initialSize = elementSize + 5;
        int[] temp = new int[initialSize];

        for(int i=0; i<elementSize; ++i)
            temp[i] = this.array[i];

        this.array = temp;
    }

    public int indexOf(int number){
       for (int i=0; i<elementSize; ++i){
           if(array[i] == number)
               return i;
       }
       return -1;
    }

    public int size(){
        return this.elementSize;
    }

    public void print(){
        for (int i=0; i < elementSize; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
