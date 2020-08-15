package Assignmnet6;

public class Test {
    // Custom chainhashmap with load factor of 0.8;
    static ChainHashMap<String, String> testMap1 = new ChainHashMap<>(10, 21,0.8);
    static SortedTableMap<String, String> testMap2= new SortedTableMap<>();

    public static void main(String[] args) {
        // Test for exercise 1
        fillChainHashMap(testMap1);
        System.out.println();
        printChainMap(testMap1);
        fillSortedMap(testMap2);
        System.out.println();
        // Test for exercise 2
        System.out.println("Does it contain Canada? " +testMap2.containsKey("Canada"));
        System.out.println("Does it contain Saudi Arabia? " +testMap2.containsKey("Saudi Arabia"));

    }
    public static void fillChainHashMap(ChainHashMap chm){
        chm.put("Canada","Toronto");
        System.out.println("Add input 1, Capacity @ "+chm.capacity);
        chm.put("Australia","Sydney");
        System.out.println("Add input 2, Capacity @ "+chm.capacity);
        chm.put("Poland","Warsaw");
        System.out.println("Add input 3, Capacity @ "+chm.capacity);
        chm.put("United States","New York");
        System.out.println("Add input 4, Capacity @ "+chm.capacity);
        chm.put("China","Shanghai");
        System.out.println("Add input 5, Capacity @ "+chm.capacity);
        chm.put("United Kingdom","London");
        System.out.println("Add input 6, Capacity @ "+chm.capacity);
        chm.put("France","Paris");
        System.out.println("Add input 7, Capacity @ "+chm.capacity);
        chm.put("Korea","Seoul");
        System.out.println("Add input 8, Capacity @ "+chm.capacity);
        chm.put("Turkey","Istanbul");
        System.out.println("Add input 9, Capacity @ "+chm.capacity);
        chm.put("Japan","Tokyo");
        System.out.println("Add input 10, Capacity @ "+chm.capacity);
        chm.put("Germany","Berlin");
        System.out.println("Add input 11, Capacity @ "+chm.capacity);
    }

    public static void fillSortedMap(SortedTableMap chm){
        chm.put("Canada","Toronto");
        chm.put("Australia","Sydney");
        chm.put("Poland","Warsaw");
        chm.put("United States","New York");
        chm.put("China","Shanghai");
        chm.put("United Kingdom","London");
        chm.put("France","Paris");
        chm.put("Korea","Seoul");
        chm.put("Turkey","Istanbul");
        chm.put("Japan","Tokyo");
        chm.put("Germany","Berlin");
    }

    public static void printChainMap(ChainHashMap<String,String> chm){
        for ( Entry<String,String> es:  chm.entrySet()
             ) {
            System.out.println(es.getKey()+":"+es.getValue());
        }
    }
}
