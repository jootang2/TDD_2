package org.example.TDD_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashMap <K, V> {
    int size = 0;
    Object[] keys;
    Object[] values;

    public HashMap(){
        size = 0;
        keys = new Object[100];
        values = new Object[100];
    }


    public void put(K key, V value) {
       int keyIndex = indexOfKey(key);

       if(keyIndex != -1){
           values[keyIndex] = value;
           return;
       }

       keys[size] = key;
        values[size] = value;
        size++;


    }

    public V get(K key) {
      int keyIndex = indexOfKey(key);

      if(keyIndex == -1){
          return null;
      }

      return (V) values[keyIndex];


    }

    private int indexOfKey(K key){
        for(int i=0; i<size; i++){
            if(keys[i].equals(key)){
                return i;
            }
        }

        return -1;
    }


    public void remove(K key) {
        int keyIndex = indexOfKey(key);
        if(keyIndex == -1){
            return;
        }

        moveLeft(keys, keyIndex , size-1);
        moveLeft(values , keyIndex , size-1);
        size--;
    }

    private void moveLeft(Object[] arr, int keyIndex , int toIndex) {

        for(int i=keyIndex; i<toIndex; i++){
            arr[i-1] = arr[i];
        }




    }

    public int size() {
        return size;
    }

    public List<K> keySet() {
        List<K> keySet = new ArrayList<>();

        for(int i=0; i<size; i++){
            keySet.add((K) keys[i]);
        }
        return keySet;

    }
}
