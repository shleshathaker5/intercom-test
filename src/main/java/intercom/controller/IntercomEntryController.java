package intercom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import intercom.domain.Customer;
import intercom.service.CustomerDataService;


@Controller
public class IntercomEntryController {
	
	private static final Logger logger = LoggerFactory.getLogger(IntercomEntryController.class);
	
    @Autowired
	CustomerDataService processCustomerData;
	
	/**
	 * 
     * <p> This method is the entry point to the application and will return list of customer within 100km
     * to dublin office.</p>
     * 
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.GET, value="/getCustomerData")
	public String intercomEntry(Model model) throws Exception {
		List<Customer> customerList;
		try {
			customerList=	processCustomerData.calcCustomerDistance();
			model.addAttribute("customerList",customerList);
			logger.info("Sucessfully retreived "+customerList.size()+" within 100km to Dublin office");
	    	
		} catch (Exception e) {
			logger.error("Error while retreiving customer details within 100km to Dublin office ");
		}
			return "welcome";
		
		}

}
