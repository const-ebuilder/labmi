package com.ebuilder.labmi.db;

import com.ebuilder.labmi.model.Animal;

import java.util.UUID;

public class AnimalDAO extends DynamoDAO {

    public AnimalDAO(DynamoDbFactory factory) {
        super(factory);
    }

    public Animal getByName(String name)  {
       return dynamoDBMapper.load(Animal.class, name);
    }

    public Animal save(Animal animal) {
        animal.setId(UUID.randomUUID().toString());
        dynamoDBMapper.save(animal);
        return animal;
    }

}
