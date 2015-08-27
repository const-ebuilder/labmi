package com.ebuilder.labmi.db;

import com.ebuilder.labmi.model.Animal;

public class AnimalDAO extends DynamoDAO {

    public AnimalDAO(DynamoDbFactory factory) {
        super(factory);
    }

    public Animal getByName(String name)  {
       return dynamoDBMapper.load(Animal.class, name);
    }

}
