package com.training.hashtable;

public class MapNode<K,V> {
    K key;
    V value;
    MapNode<K,V> next;

    public MapNode(K key,V value){
        this.key=key;
        this.value=value;
        this.next=null;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MapNode<K, V> getNext() {
        return next;
    }

    public void setNext(MapNode<K, V> next) {
        this.next = next;
    }
}
