package com.houarizegai.javase.java8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        System.out.println("LinkedList:");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Houari");
        linkedList.add("Mohamed");
        linkedList.add(1, "AEK");
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);

        
    }
}
