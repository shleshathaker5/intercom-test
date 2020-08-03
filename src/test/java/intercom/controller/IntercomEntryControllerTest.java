package intercom.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import intercom.domain.Customer;
import intercom.service.CustomerDataServiceImpl;

public class IntercomEntryControllerTest {
	
	@InjectMocks
	IntercomEntryController intercomEntryController = new IntercomEntryController();
	
	private MockMvc mockMvc;
	
	@Mock
	Model model;
	
	@BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	this.mockMvc = MockMvcBuilders.standaloneSetup(intercomEntryController).build();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testintercomEntry() throws Exception{
    	this.mockMvc.perform(get("/getCustomerData")).andExpect(status().isOk());
    	
    }
    
    
    @Test
    public void testintercomInvalidUrl() throws Exception {
    	this.mockMvc.perform(get("/")).andExpect(status().is4xxClientError());
    	
    }

}
