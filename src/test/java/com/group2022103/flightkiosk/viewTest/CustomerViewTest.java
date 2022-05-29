package com.group2022103.flightkiosk.viewTest;
import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.util.CsvUtil;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerViewTest {
    @Test
    public void CustomerTest(){
        Application.run();
        CustomerView customerView = new CustomerView(new CustomerBack(){{
            setID(1);
        }});
        assertEquals("Yunuo",customerView.getCustomer().getFirstname());
        assertEquals("Wang",customerView.getCustomer().getSurname());
        assertEquals("123456789012345678",customerView.getCustomer().getCustomerId());
        assertEquals("4001234567",customerView.getCustomer().getCreditId());
        assertEquals("f5bb0c8de146c67b44babbf4e6584cc0",customerView.getCustomer().getPassword());
    }
    @Test
    public void isValidTest(){
        Application.run();
        CustomerView customerView = new CustomerView(new CustomerBack(){{
            setCustomerID("123456789012345678");
        }});
        assertEquals(true,customerView.isValid("4001234567", "123123123"));
    }
}
