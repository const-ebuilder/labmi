package com.ebuilder.labmi.db;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import org.junit.Test;

/**
 * Created by konstantin.kachanovsky@ebuilder.com on 8/27/2015.
 */
public class FooDynamoDBTest {

    @Test
    public void worksWithAwsDynamoDb() {
        AmazonDynamoDB aws = new AmazonDynamoDBClient(
                new BasicAWSCredentials("", "")
        );
        aws.setEndpoint("http://localhost:10500");
        ListTablesResult list = aws.listTables();
        for (String name : list.getTableNames()) {
            System.out.println("table found: " + name);
        }
    }
}
