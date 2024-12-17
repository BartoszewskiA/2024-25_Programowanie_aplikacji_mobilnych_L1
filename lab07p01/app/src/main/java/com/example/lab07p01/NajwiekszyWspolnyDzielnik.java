package com.example.lab07p01;

public class NajwiekszyWspolnyDzielnik {
    private int a;
    private int b;

    public NajwiekszyWspolnyDzielnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getNajwiekszyWspolnyDzielnik() {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
