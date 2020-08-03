package intercom.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import intercom.domain.Customer;
import jdk.Exported;

public class CustomerDataServiceImplTest{

	@Mock
	CustomerDataServiceImpl customerDataServiceImp;
	
	@Mock
	InputStream inputStream;
	
	@InjectMocks
	CustomerDataServiceImpl customerDataServiceImpl = new CustomerDataServiceImpl();
	
	@Rule
	public ExpectedException expectedException=ExpectedException.none();
	
	@BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    	 MockitoAnnotations.initMocks(this);
    }
    

    @After
    public void tearDown() {
    }
    
    @Test
    public void testcalcCustomerDistance(){
    	List<Customer> custList=customerDataServiceImpl.calcCustomerDistance();
    	int customerCount = 16;
    	assertEquals(custList.size(),customerCount);
    }
    
    @Test(expected = NullPointerException.class)
    public void testExceptionOnReadingFile() throws Exception {
    	URL url = new URL("https://s3.amazonaws.com/intercom-take-home-test/customers.txt");

    	InputStreamReader fileContents = spy(new InputStreamReader(null)); 
    	doThrow(new IOException()).when(fileContents).read(any(char[].class));
    	List<Customer> custList=customerDataServiceImpl.calcCustomerDistance();
    }
 }
