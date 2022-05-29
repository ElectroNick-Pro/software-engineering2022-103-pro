package com.group2022103.flightkiosk.viewTest;
import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.view.FoodView;
import com.group2022103.flightkiosk.vo.FoodBack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodViewTest {
    @Test
    public void FoodNumberTest(){
        Application.run();
        FoodView foodView = new FoodView(new FoodBack(){{
            setFlightId(3);
        }});
        assertEquals(9,foodView.getOriginFood().size());
        assertEquals(9,foodView.getExtraFood().size());
    }
}
