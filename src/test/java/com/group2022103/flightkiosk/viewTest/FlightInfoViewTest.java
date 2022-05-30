package com.group2022103.flightkiosk.viewTest;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import org.junit.Test;

public class FlightInfoViewTest {
    @Test
    public void testFlightView(){
        Application.run();
		new TicketView(new TicketBack() {{
			setSurname("");
			setDocumentID("123456789012345678");
		}});
		
	}
    
}
