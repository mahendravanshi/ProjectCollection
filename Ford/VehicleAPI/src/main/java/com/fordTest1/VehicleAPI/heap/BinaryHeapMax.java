package com.fordTest1.VehicleAPI.heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeapMax {

      private List<Integer> heap;


      public BinaryHeapMax(){
          heap = new ArrayList<>();
      }

      public void insert(int data){

            heap.add(data);
            heapifyUp(heap.size()-1);
      }

      public int extractMax(){

            if(heap.size()==0) throw new IllegalArgumentException("Heap is empty");

            int max = heap.get(0);

            int lastEl = heap.remove(heap.size()-1);


            heap.set(0,lastEl);

            heapifyDown(0);
            return max;


      }

      private void heapifyDown(int index) {

            int leftChildIndex = 2*index+1;
            int rightChildIndex = 2*index+2;

            int biggest  = index;

            if(leftChildIndex <heap.size() && heap.get(leftChildIndex) > heap.get(biggest)){
                   biggest = leftChildIndex;
            }

            if(rightChildIndex <heap.size() && heap.get(rightChildIndex) > heap.get(biggest)){
                  biggest = rightChildIndex;
            }

            if(biggest!=index){
                  swap(biggest,index);
                  heapifyDown(biggest);
            }


      }

      public void heapifyUp(int index){

            int parentIndex = (index-1)/2;

            if(index > 0 && heap.get(index) > heap.get(parentIndex)){
                 swap(index,parentIndex);
                 heapifyUp(parentIndex);
            }
      }

      public void swap(int i,int j){

             int temp = heap.get(i);

             heap.set(i,heap.get(j));
             heap.set(j,temp);
      }

      @Override
      public String toString() {
            return "BinaryHeapMax{" +
                    "heap=" + heap +
                    '}';
      }
}
