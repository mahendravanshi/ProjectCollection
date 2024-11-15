package com.fordTest1.VehicleAPI.heap;

public class Main {

    public static void main(String[] args) {

         BinaryHeap bh = new BinaryHeap();

         bh.insert(5);
        bh.insert(5);
        bh.insert(10);
        bh.insert(9);
        bh.insert(8);
        bh.insert(5);
        bh.insert(25);
        bh.insert(16);

        //System.out.println(bh);

        BinaryHeapMax bm = new BinaryHeapMax();
        bm.insert(1);
        bm.insert(4);
        bm.insert(26);
        bm.insert(28);
        bm.insert(42);
        bm.insert(24);
        bm.insert(24);


        System.out.println(bm.extractMax());
        System.out.println(bm.extractMax());
        System.out.println(bm.extractMax());
        System.out.println(bm.extractMax());
        System.out.println(bm.extractMax());
    }
}
