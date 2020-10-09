package com.training.hashtable;

import java.util.ArrayList;

public class HashTable<K,V> {
    public int bucketSize = 10;
    private ArrayList<MapNode<K, V>> bucketArray;
    private int size;

    public HashTable()
    {
        bucketArray = new ArrayList<>();
        bucketSize = 10;
        size = 0;

        for (int i = 0; i < bucketSize; i++)
            bucketArray.add(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % bucketSize;
        return index;
    }

    public V get(K key) {

        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
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
        String s = "To be or not to be";
        String[] array = s.split(" ");
        HashTable<String,Integer> hashMap = new HashTable<>();
        for (String a : array ) {
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
