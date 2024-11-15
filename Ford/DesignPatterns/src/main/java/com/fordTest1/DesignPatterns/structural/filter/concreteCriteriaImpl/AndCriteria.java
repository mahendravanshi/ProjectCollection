package com.fordTest1.DesignPatterns.structural.filter.concreteCriteriaImpl;

import com.fordTest1.DesignPatterns.structural.filter.Criteria;
import com.fordTest1.DesignPatterns.structural.filter.Person;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);

    }
}
