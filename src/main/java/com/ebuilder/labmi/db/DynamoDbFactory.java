/**
 * 
 */
package com.ebuilder.labmi.db;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author pradeeppeiris
 *
 */
public class DynamoDbFactory {

	private static final Logger log = LoggerFactory.getLogger(DynamoDbFactory.class);

	private static DynamoDbFactory instance;
	
	private DynamoDBMapper dynamoDBMapper;
	
	private DynamoDB dynamoDB;
	
	private DynamoDbFactory(String credentialGroup, String regionCode) {
		this.init(credentialGroup, regionCode);
	}
	
	/**
	 * Initialize reference to instance of DynamoDB and DynamoDBMapper
	 * DynamoDB and DynamoDBMapper are constructed from AmazonDynamoDBClient instance,
	 * which is reusable indefinitely. Therefore, we can make instance of DynamoDAO  
	 * reusable across multiple requests.
	 * (TODO: Verify this with a load test)
	 * 
	 * @param credentialGroup
	 * 				Profile credential id. This is specified in 
	 * 				HOME/.aws/credentials
	 * @param region
	 * 				AWS region that DynamoDB resides
	 */
	private void init(String credentialGroup, String regionCode) {
		log.info("Initiate a type of DynamoDbFactory: " + credentialGroup + ", Region: " + regionCode);
    	AWSCredentials credentials = new ProfileCredentialsProvider(credentialGroup).getCredentials();
    	AmazonDynamoDBClient dynamoClient = new AmazonDynamoDBClient(credentials);
        Region region = Region.getRegion(Regions.fromName(regionCode));
        dynamoClient.setRegion(region);
 
        dynamoDBMapper = new DynamoDBMapper(dynamoClient);
        dynamoDB = new DynamoDB(dynamoClient);
	}

	public static DynamoDbFactory getInstance(String credentialGroup, String regionCode){
		log.info("DynamoDbFactory getInstance");
		if(instance == null) {
			instance = new DynamoDbFactory(credentialGroup, regionCode);
		}
		
		return instance;
	}

	public DynamoDBMapper getDynamoDBMapper() {
		return dynamoDBMapper;
	}

	public DynamoDB getDynamoDB() {
		return dynamoDB;
	}
	
	
}
