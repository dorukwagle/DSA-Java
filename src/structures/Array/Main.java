package structures.Array;

public class Main {
    public static void main(String[] args) {
        Array item = new Array();
        for(int i=54; i<59; ++i)
            item.insert(i);
        System.out.println(item.size());
        item.print();
        item.removeAt(0);
        item.removeAt(2);
        item.removeAt(5);
        item.print();
//        System.out.println(item.indexOf(57));
    }
}
