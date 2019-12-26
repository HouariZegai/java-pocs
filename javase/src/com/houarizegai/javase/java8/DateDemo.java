package com.houarizegai.javase.java8;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date oldDate = new Date(1499999990099L); // Fri Jul 14 03:39:50 WAT 2017
        Date dateNow = new Date();

        System.out.println(oldDate);
        System.out.println(dateNow.getTime());
        System.out.println(dateNow.after(oldDate));
        System.out.println(dateNow.before(oldDate));
        System.out.println(dateNow.compareTo(oldDate));
        System.out.println(dateNow.equals(oldDate));
    }
}
