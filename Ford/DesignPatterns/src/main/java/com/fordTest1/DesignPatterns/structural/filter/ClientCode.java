package com.fordTest1.DesignPatterns.structural.filter;

import com.fordTest1.DesignPatterns.structural.filter.concreteCriteriaImpl.*;

import java.util.ArrayList;
import java.util.List;

public class ClientCode {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("John", "Male", "Single"));
        persons.add(new Person("Sarah", "Female", "Married"));
        persons.add(new Person("Mike", "Male", "Married"));
        persons.add(new Person("Anna", "Female", "Single"));
        persons.add(new Person("James", "Male", "Single"));


        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();


        Criteria singleMale = new AndCriteria(single,male);
        Criteria singleOrFemale = new OrCriteria(single,female);


        System.out.println("Male");
        printPersons(male.meetCriteria(persons));


        System.out.println("Female");
        printPersons(female.meetCriteria(persons));


        System.out.println("Single");
        printPersons(single.meetCriteria(persons));


        System.out.println("MaleSingleAnd");
        printPersons(singleMale.meetCriteria(persons));


        System.out.println("Female or single");
        printPersons(singleOrFemale.meetCriteria(persons));


    }


    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
