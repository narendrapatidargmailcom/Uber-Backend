package com.booking.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo {

    public static void main(String args[]){
        List<Integer> l1 = Arrays.asList(1,-50,30,4,50,3,3,4);

        Collections.sort(l1);
        int i=0;
        int j=l1.size()-1;
        while (i<j){
           System.out.println(l1.get(j)+" "+l1.get(i));
           i++;
           j--;
        }
    }
}
