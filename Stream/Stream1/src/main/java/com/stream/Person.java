package com.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private Integer id;
    private Double price;
    private String name;


    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        // Adding 10 objects of Person class to the list
        personList.add(new Person(1, 1000.0, "John"));
        personList.add(new Person(2, 1500.0, "Alice"));
        personList.add(new Person(3, 800.0, "Eva"));
        personList.add(new Person(4, 800.0, "Bob"));
        personList.add(new Person(5, 900.0, "Mike"));
        personList.add(new Person(6, 1100.0, "Sophia"));
        personList.add(new Person(7, 1300.0, "Daniel"));
        personList.add(new Person(8, 3950.0, "Olivia"));
        personList.add(new Person(9, 750.0, "Charlie"));
        personList.add(new Person(10, 1600.0, "Emma"));

        List<Person> priceGreaterThan800 = personList.stream().filter(x->x.getPrice()>800).collect(Collectors.toList());
//        System.out.println(priceGreaterThan800);

        // sumOfAll
        Double totalPrice = personList.stream().mapToDouble(Person::getPrice).reduce(0, Double::sum);
//        System.out.println(totalPrice);

//        filterByPriceIncrease

        List<Person> filterByPriceIncreaseThenName= personList.stream()
                .sorted(Comparator.comparingDouble(Person::getPrice).thenComparing(Person::getName))
                .collect(Collectors.toList());
//        System.out.println(filterByPriceIncreaseThenName);

//        Find the average price of all persons in the list.

        Double avg = personList.stream().mapToDouble(Person::getPrice).average().orElse(0.0);

//        System.out.println(avg);

//        Filter and print the names of persons whose price is greater than 1000.0.

        List<String> namesWithPriceGreaterThan1000  = personList.stream().filter(x->x.getPrice()>1000.0).map(Person::getName).collect(Collectors.toList());
//        System.out.println(namesWithPriceGreaterThan1000);

        boolean checkPersonWithPriceGreaterThan2000  = personList.stream().filter(x->x.getPrice()>2000.0).count()>0?true:false;
        System.out.println(checkPersonWithPriceGreaterThan2000);

//        Create a Map where the key is the person's name, and the value is their price.

        Map<String,Double> map = personList.stream().collect(Collectors.toMap(Person::getName,Person::getPrice));

//        System.out.println(map);

//        Find the person with the highest price.

        Person personWithHighestPrice = personList.stream().sorted(Comparator.comparingDouble(Person::getPrice).reversed()).collect(Collectors.toList()).get(0);
//        System.out.println(personWithHighestPrice);

//      Calculate the total price of all persons in the list.

        Double total = personList.stream().mapToDouble(Person::getPrice).sum();
//        System.out.println(total);

//         Group persons by their prices.
//           / Group persons by their prices
        Map<Double, List<Person>> groupedByPrice = personList.stream()
                .collect(Collectors.groupingBy(Person::getPrice));

        // Print the result
        groupedByPrice.forEach((price, persons) -> {
            System.out.println("Price: " + price);
            persons.forEach(person -> System.out.println("  - " + person.getName()));
        });


//        Partition persons into two groups: those with a price greater than 1000.0 and those with a price less than or equal to 1000.0.

       Map<Boolean,List<Person>> groupByPrice =  personList.stream().collect(Collectors.partitioningBy(p->p.getPrice()>1000));

        List<Person> greaterThan1000 = personList.stream()
                .filter(person -> person.getPrice() > 1000.0)
                .collect(Collectors.toList());

        List<Person> lessThanOrEqual1000 = personList.stream()
                .filter(person -> person.getPrice() <= 1000.0)
                .collect(Collectors.toList());



    }


}
