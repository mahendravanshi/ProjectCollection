package com.prep.var;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private int name;

    public void getData(){
         var name = "Mahendra";
         var list = List.of(1,2,3,4,5);

        System.out.println("name is "+ name+ " list is "+list);

    }

    public static void main(String[] args) {

//         Product product = new Product();
//         product.getData();

         List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

         Map<Integer,Long> map =  list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));

         map.entrySet().stream().filter(entry->entry.getValue()==1).forEach((entry)-> System.out.println(entry.getKey()+" "+entry.getValue()));




    }
}


