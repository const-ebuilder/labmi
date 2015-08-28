package com.ebuilder.labmi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by alz on 27-Aug-15.
 */
@DynamoDBTable(tableName = "animal")
public class Animal {

    //This index name is defined in the DB and also DynamoDBIndexHashKey under email attribute
    public final static String  indexEmail = "amimmal-index";

    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @DynamoDBAttribute(attributeName = "number_of_legs")
    @NotNull
    @Size(min = 1, max = 50)
    private String numberOfLegs;

    @DynamoDBAttribute(attributeName = "color")
    @NotNull
    @Size(min = 1, max = 50)
    private String color;

    public Animal() {
        //deserialization for Jackson
    }

    public Animal(String id, String firstName, String color, String numberOfLegs) {
        this.id = id;
        this.name = firstName;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    @JsonProperty
    @XmlElement(name = "name")
    @ApiModelProperty(value = "Animal name", required = true)
    public String getName() {
        return name;
    }

    @JsonProperty
    @XmlElement(name = "color")
    @ApiModelProperty(value = "Animal color", required = true)
    public String getColor() {
        return color;
    }

    @JsonProperty
    @XmlElement(name = "numberOfLegs")
    @ApiModelProperty(value = "Number of legs", required = true)
    public String getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setId(String id) {
        this.id = id;
    }

}
