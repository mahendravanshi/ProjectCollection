package com.fordTest1.DesignPatterns.behavioural.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

     private List<Memento> mementoList = new ArrayList<>();

     public void add(Memento state){
         this.mementoList.add(state);
     }

     public Memento get(int index){
         return mementoList.get(index);
     }


}
