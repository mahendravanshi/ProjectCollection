package com.fordTest1.DesignPatterns.structural.filter.concreteCriteriaImpl;

import com.fordTest1.DesignPatterns.structural.filter.Criteria;
import com.fordTest1.DesignPatterns.structural.filter.Person;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {

          return persons.stream().filter(person-> person.getGender().equalsIgnoreCase("MALE")).collect(Collectors.toList());
    }
}