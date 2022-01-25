package com.houarizegai.oca.exam;

interface CanClimb {
    int maxHeight();
}

interface HasClaws {
    boolean isSharp();
}

public class Koala implements CanClimb, HasClaws {

    public boolean isSharp() {
        return true;
    }

    public int maxHeight() {
        return 15;
    }

    public static void main(String[] args) {
        Object koala = new Koala();
        CanClimb canClimb = (CanClimb) koala;
        HasClaws hasClaws = (HasClaws) canClimb;
        System.out.print(canClimb.maxHeight());
        System.out.print(hasClaws.isSharp());
    }
}
