package com.group11.sportify.plans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TestPlanActivity {
    @Test
    public void testPlanActivityConstructor(){
        PlanActivity planActivity1 = new PlanActivity(28, 26);
        assertNotNull(planActivity1);
        PlanActivity planActivity2 = new PlanActivity(planActivity1);
        assertNotNull(planActivity2);
    }

    @Test
    public void testGetIterations(){
        PlanActivity planActivity = new PlanActivity(28, 26);
        assertEquals(planActivity.getIterations(), 28);
    }

    @Test
    public void testGetActivityCode(){
        PlanActivity planActivity = new PlanActivity(28, 26);
        assertEquals(planActivity.getActivityCode(), 26);
    }

    @Test
    public void testSetIterations(){
        PlanActivity planActivity = new PlanActivity(28, 26);
        assertEquals(planActivity.getIterations(), 28);
        planActivity.setIterations(10);
        assertEquals(planActivity.getIterations(), 10);
    }
}
