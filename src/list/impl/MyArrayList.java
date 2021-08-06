package list.impl;

import list.GBIterator;
import list.GBList;

import java.util.NoSuchElementException;

public class MyArrayList implements GBList {
    private int size;
    private String [] list;
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public MyArrayList() {
        this.list = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public void add(String val) {
        if (size == list.length)
            list = grow();
        list[size] = val;
        size = size + 1;
    }

    //не успела
    @Override
    public boolean remove(String val) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        if(index>size){
            throw new NoSuchElementException("Такого элемента нет в коллекции");
        }
        return list[index];
    }

    private String[] grow(){
        String []  newList = new String [size+1];
        for(int i = 0; i<size; i++){
            newList[i] = list[i];
        }
        return newList;
    }
}
