package intercom.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import intercom.domain.Customer;
import intercom.utility.CalculateDistanceUtilities;



@Service
public class CustomerDataServiceImpl implements CustomerDataService{
		
	private static final Logger logger = LoggerFactory.getLogger(CustomerDataServiceImpl.class);
	
	/**
     * Dublin Office latitude and longitude.
     */
    private static final double DUB_OFFICE_LAT = 53.339428;
    private static final double DUB_OFFICE_LON = -6.257664;
    private static final int DISTANCE = 100;
    private static final String CUSTOMERS_URL = "https://s3.amazonaws.com/intercom-take-home-test/customers.txt"; 
    /**
     * @return
     * @throws Exception
     */
    public List<Customer> calcCustomerDistance()
    {
    	logger.info("inside calcCutomerDistance method");
    	ArrayList<Customer> customerList = readCustomerInfo();
    	List<Customer> matchingcustList=null;
    	if(!customerList.isEmpty()) {
    	matchingcustList=distanceFromDublinOffice(customerList);
    	}
    	logger.info("Found "+matchingcustList.size()+" matching customers");
    	
		return matchingcustList;
    }

	/**
	 * <p>
     * Method to read and process customer info from text file </p>
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws FileNotFoundException
	 */
	private ArrayList<Customer> readCustomerInfo(){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		       
    	try{
    		URL url = new URL(CUSTOMERS_URL);
    		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            while(line!=null){
            	ObjectMapper mapper = new ObjectMapper();
                Customer object= mapper.readValue(line, Customer.class);
                customerList.add(object);
                line=reader.readLine();
            }
            logger.info(customerList.size()+" customers data to be processed");  
        } catch (IOException e) {
        	logger.error("IOException occured while reading the customer data");
		} catch(Exception e)
    	{
    		logger.error("Exception occured while reading the customer data");
    	}
		return customerList;
	}

	/**
	 * <p>
     * Method to calculate distance for each customer from dublin office </p>
	 * @param customerList
	 * @return 
	 */
	private List<Customer> distanceFromDublinOffice(ArrayList<Customer> customerList) {
		List<Customer> matchingCustList = new ArrayList<Customer>();
		for(Customer customer:customerList) {
			double distance=CalculateDistanceUtilities.distanceInKiloMetres(DUB_OFFICE_LAT, DUB_OFFICE_LON, customer.latitude, customer.longitude);
			int intDistance = (int) Math. round(distance);
			if(intDistance<DISTANCE) {
				matchingCustList.add(customer);
			}
		}
		Collections.sort(matchingCustList);
		 logger.info(matchingCustList.size()+" customers found within 100km to Dublin office");  
		return matchingCustList;
	}

}
