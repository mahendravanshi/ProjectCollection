package com.design.builder;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
public class Product{

        private int id;
        private String name;
        private int price;

      @Override
      public boolean equals(Object o){

            if(this==o) return true;
            if(o==null || this.getClass()!=o.getClass()) return false;

            Product other = (Product) o;

            return this.id== other.getId()&&this.getPrice()== other.getPrice()&&Objects.equals(this.name,other.getName());

      }


//     @Override
//     public int hashCode(){
//          return Objects.hash(id,name,price);
//     }


    private Product(){}


        public static ProductBuilder builder(){
              return new ProductBuilder();
        }


        public static class ProductBuilder{

            private int id;
            private String name;
            private int price;
               private ProductBuilder(){}

               public ProductBuilder id(int id){
                   this.id = id;
                   return this;
               }


               public ProductBuilder price(int price){
                   this.price = price;
                   return this;
               }

               public ProductBuilder name(String name){
                   this.name = name;
                   return  this;

               }

               public Product build(){

                   Product product = new Product();
                   product.id = this.id;
                   product.name = this.name;
                   product.price = this.price;
                   return product;
               }
        }


    public static void main(String[] args) {

        Product product = Product.builder().id(1).price(10).build();
//       System.out.println(product);

        Product p1 = Product.builder().id(1).price(10).build();



    }



}
