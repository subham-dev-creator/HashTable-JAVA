package com.training.hashtable;

import java.util.ArrayList;

public class HashTable<K,V> {
    public int bucketSize ;
    private ArrayList<MapNode<K, V>> bucketArray;
    private int size;

    public HashTable()
    {
        bucketArray = new ArrayList<>();
        bucketSize = 20;
        size = 0;

        for (int i = 0; i < bucketSize; i++)
            bucketArray.add(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        if(hashCode<0)
            hashCode*=(-1);
        int index = hashCode % bucketSize;
        return index;
    }

    public V get(K key) {

        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.getKey().equals(key))
                return head.getValue();
            head = head.getNext();
        }

        return null;
    }

    public void put(K key,V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArray.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
    }

    public static void main(String[] args) {
        String s = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] array = s.split(" ");
        HashTable<String,Integer> hashMap = new HashTable<>();
        for (String a : array) {
            Integer temp = hashMap.get(a);

            if(temp==null)
                hashMap.put(a,1);
            else
                hashMap.put(a,temp+1);
        }

        for(String a : array){
            System.out.println(a + " --->> " + hashMap.get(a));
        }
    }

}
