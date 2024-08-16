package org.example;

import java.util.Arrays;

public class CalculateArea {

    public int areaOfSq(int length){
        return length * length;
    }

    public int[] sortingArray(int[] array){
        Arrays.sort(array);
        return array;
    }

    public int[] sortArryTimeout(int[] array){
        for(int i=0; i<100000; i++){
            Arrays.sort(array);
        }
        return array;
    }
}
