package com.training.hashtable;

import java.util.ArrayList;
import java.util.Map;

public class HashTable<K,V> {
    public int bucketSize ;
    private ArrayList<MapNode<K, V>> bucketArray;
    private int size;

    // Initialize HashTable
    public HashTable()
    {
        bucketArray = new ArrayList<>();
        bucketSize = 20;
        size = 0;

        for (int i = 0; i < bucketSize; i++)
            bucketArray.add(null);
    }

    // Return size of HashTable
    public int size() { return size; }

    // Returns HashTable is empty or not
    public boolean isEmpty() { return size() == 0; }

    // returns the bucketIndex for the KEY
    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        if(hashCode<0)
            hashCode*=(-1);
        int index = hashCode % bucketSize;
        return index;
    }

    // Returns the Value for the KEY stored in the HASHTABLE
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

    // Inserts Key Value pair in the HASHTABLE
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

    // Remove the key and returns the VALUE for that key
    public V delete(K key){
        int bucketIndex = getBucketIndex(key);
        if(bucketArray.get(bucketIndex)==null)
            return null;
        else
        {
            size--;
            MapNode<K,V> node = bucketArray.get(bucketIndex);
            if(node.getNext()==null || node.getKey()==key)
            {
                V val = node.getValue();
                if(node.getNext()==null)
                    bucketArray.set(bucketIndex,null);
                else
                    bucketArray.set(bucketIndex,node.getNext());
                return val;

            }
            else
            {
                while(node.getNext()!=null && node.getNext().getKey()!=key){
                    node = node.getNext();
                }

                V val = node.getNext().getValue();
                node.setNext(node.getNext().getNext());
                return val;
            }
        }
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

        hashMap.delete("avoidable");

        for(String a : array){
            System.out.println(a + " --->> " + hashMap.get(a));
        }

        System.out.println(hashMap.get("avoidable"));
    }

}
