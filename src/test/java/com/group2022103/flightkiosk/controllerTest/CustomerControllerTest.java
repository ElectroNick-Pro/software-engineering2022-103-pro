package com.group2022103.flightkiosk.controllerTest;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.*;
import com.group2022103.flightkiosk.mapper.*;
import com.group2022103.flightkiosk.vo.*;
public class CustomerControllerTest {
    private CustomerMapper CustomerMapper;
	
	@Test
	public void test() {
		Application.run();
		CustomerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
		var para = new CustomerBack(){{
            setCustomerID("123456789012345678");
        }};
		String surname = new CustomerController().get(para).getCustomer().getSurname();
		assertEquals("Wang", surname);
	}
}
