package Assignmnet6;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
    protected int n = 0;    // number of entries in the dictionary
    protected int capacity; // length of the table
    private int prime;      // prime factor
    private long scale, shift;      //The shift and scaling factors
    /** Exercise 1 Addition */
    private double lfscale = 2.0;        //Load factor scale; default divide by 2 (0.5)
    public AbstractHashMap(int cap, int p, double loadFactor){
        prime = p;
        capacity = cap;
        lfscale = 1/loadFactor;
        Random rand = new Random();
        scale = rand.nextInt(prime-1)+1;
        shift = rand.nextInt(prime);
        createTable();
    }
    /** Exercise 1 Addition Ends */
    public AbstractHashMap(int cap, int p){
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime-1)+1;
        shift = rand.nextInt(prime);
        createTable();
    }
    public AbstractHashMap(int cap) {this(cap, 109345121);}     // default prime
    public AbstractHashMap(){this(17);}                       // default capacity
    // public methods
    public int size(){return n;}
    public V get(K key) {return bucketGet(hashValue(key),key);}
    public V remove(K key) {return bucketRemove(hashValue(key),key);}
    public V put(K key, V value){
        V answer = bucketPut(hashValue(key),key,value);
        /** Original **/
        /*
        if(n>capacity/2)                        // keep load factor <= 0.5
            resize(2*capacity-1);      // (or find a nearby prime)
         */
        /** Original End **/
        if(n>capacity/lfscale)                             // Custom load factor scale
            resize((int)(lfscale*capacity-1));      //
        return answer;
    }

    // private utilities
    private int hashValue(K key){
        return (int) ((Math.abs(key.hashCode()+scale+shift)%prime)%capacity);
    }
    private void resize(int newCap){
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for(Entry<K,V> e: entrySet())
            buffer.add(e);
        capacity = newCap;
        createTable();
        n=0;
        for(Entry<K,V>e:buffer)
            put(e.getKey(),e.getValue());
    }

    //protected abstract methods to be implemented by subclasses
    protected abstract void createTable();
    protected abstract V bucketGet(int h, K k);
    protected abstract V bucketPut(int h, K k , V v);
    protected abstract V bucketRemove(int h, K k);
}
