package com.fordTest1.DesignPatterns.structural.filter.concreteCriteriaImpl;

import com.fordTest1.DesignPatterns.structural.filter.Criteria;
import com.fordTest1.DesignPatterns.structural.filter.Person;

import java.util.List;

public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria,Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }


    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaList = criteria.meetCriteria(persons);
        List<Person> secondCriteriaList = otherCriteria.meetCriteria(persons);

        for(Person person: secondCriteriaList){
             if(!firstCriteriaList.contains(person)){
                 firstCriteriaList.add(person);
             }
        }


        return firstCriteriaList;

    }
}
