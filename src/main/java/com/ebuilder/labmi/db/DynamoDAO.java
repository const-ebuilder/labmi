package com.ebuilder.labmi.db;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


/**
 * Use DynamoDBMapper as the standard API
 * for accessing DynamoDB tables
 *
 * @author pradeeppeiris
 *
 */
class DynamoDAO {

	final DynamoDBMapper dynamoDBMapper;

	DynamoDAO(DynamoDbFactory factory) {
		this.dynamoDBMapper = factory.getDynamoDBMapper();
	}

}
