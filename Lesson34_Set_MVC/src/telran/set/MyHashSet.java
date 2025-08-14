package telran.set;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E>{
//    private static <T> LinkedList<T>[] newBucketArray(int capacity) {
//        return (LinkedList<T>[]) new LinkedList[capacity];
//    }
    private LinkedList<E>[] hashset;
    // 0 -> LinkedList 1 -> LinkedList ....
    private int size; //Count actual elements
    private int capacity; //Count buckets
    private double loadFactor;

    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.hashset = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity,0.75);
    }

    public MyHashSet() {
        this(16);
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean add(E element) {
        if(size>=capacity*loadFactor)
            rebuildArray();
        int index = getIndex(element);
        if(hashset[index] == null)
            hashset[index] = new LinkedList<>();
        if (hashset[index].contains(element))
            return false;
        hashset[index].add(element);
        size++;
        return true;
    }

    private int getIndex(E element) {
        int hashcode = element.hashCode();
        hashcode = hashcode >= 0 ? hashcode : -hashcode;
        return hashcode % capacity;
    }

    private void rebuildArray() {
        capacity *= 2;
        LinkedList<E>[] newHashSet = new LinkedList[capacity];
        for (int i = 0; i < hashset.length; i++) {
            if(hashset[i] != null) {
                for (E e : hashset[i]) {
                    int index = getIndex(e);
                    if(newHashSet[index]==null) {
                        newHashSet[index] = new LinkedList<>();
                    }
                    newHashSet[index].add(e);
                }
            }
        }
        hashset = newHashSet;
    }

    @Override
    public boolean contains(E element) {
        int index = getIndex(element);
        if(hashset[index] == null)
            return false;
        return hashset[index].contains(element);
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);
        if(hashset[index] == null)
            return false;
        boolean res = hashset[index].remove(element);
        if(res)
            size--;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int totalCounter; //common count for elements
            int i; //counter for number
            int j; //counter for each LinkedList in buckets


            @Override
            public boolean hasNext() {
                return totalCounter < size;
            }

            @Override
            public E next() {
                while(hashset[i]==null||hashset[i].isEmpty())
                    i++;
                E res = hashset[i].get(j);
                totalCounter++;
                if(j < hashset[i].size() - 1)
                    j++;
                else {
                    j = 0;
                    i++;
                }
                return res;
            }
        };
    }
}
