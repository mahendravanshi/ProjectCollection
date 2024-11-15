package com.fordTest1.VehicleAPI.heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

     private List<Integer> heap ;


     public BinaryHeap(){
         heap = new ArrayList<>();
     }

     public void insert(int data){
         heap.add(data);
         heapifyUp(heap.size()-1);
     }

     public void heapifyUp(int index){

           int parentIndex = (index-1)/2;

           if(index>0 && heap.get(index)< heap.get(parentIndex)){
                swap(index,parentIndex);
                heapifyUp(parentIndex); // now index element is at parentIndex after swap
           }
     }

     public int extractMin(){
          if(heap.size()==0){
               throw new IllegalStateException("No element present in heap");
          }
          int min = heap.get(0);

          int lastElement = heap.remove(heap.size()-1);

          if(heap.size()>0){
               heap.set(0,lastElement);
               heapifyDown(0);
          }

         return min;
     }


    private void heapifyDown(int index) {

         int leftChild = 2*index+1;
         int rightChild = 2*index+2;

         int smallest = index;

         if(leftChild< heap.size() && heap.get(leftChild) < heap.get(smallest)){
              smallest = leftChild;
         }

         if(rightChild< heap.size() && heap.get(rightChild) < heap.get(smallest)){
              smallest = rightChild;
         }

         if(smallest != index){
             swap(index,smallest);
             heapifyDown(smallest);
         }
    }


    public void swap(int i,int j){
          int temp = heap.get(i);
          heap.set(i,heap.get(j));
          heap.set(j,temp);
    }


    @Override
    public String toString() {
        return "BinaryHeap{" +
                "heap=" + heap +
                '}';
    }
}

