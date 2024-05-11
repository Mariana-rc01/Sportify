package com.group11.sportify.plans;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class TrainingPlanTest {
    @Test
    public void testTrainingPlanConstructor(){
        TrainingPlan trainingPlan1 = new TrainingPlan();
        assertNotNull(trainingPlan1);
        TrainingPlan trainingPlan2 = new TrainingPlan(LocalDateTime.now(), 1);
        assertNotNull(trainingPlan2);
    }

    @Test
    public void testGetStartDate(){
        LocalDateTime date = LocalDateTime.now();
        TrainingPlan trainingPlan = new TrainingPlan(date, 1);
        assertEquals(trainingPlan.getStartDate(), date);
    }
    
    @Test
    public void testSetStartDate(){
        LocalDateTime date = LocalDateTime.now();
        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setStartDate(date);
        assertEquals(trainingPlan.getStartDate(), date);
    }

    @Test
    public void testGetPlanActivities(){
        TrainingPlan plan = new TrainingPlan();
        plan.addPlanActivity(1);
        plan.addPlanActivity(2);
        plan.addPlanActivity(3);
        
        assertEquals(plan.getPlanActivities(), new ArrayList<Integer>(){{add(1); add(2); add(3);}});
    } 
    
    @Test
    public void testsetPlanActivities(){
        TrainingPlan plan = new TrainingPlan();
        HashSet<Integer> activities = new HashSet<>();
        activities.add(0);
        activities.add(1);
        activities.add(2);
        plan.setPlanActivities(activities);
        assertEquals(plan.getPlanActivities(), new ArrayList<Integer>(){{add(0); add(1); add(2);}});
    }
    
    @Test
    public void testAddPlanActivity(){
        TrainingPlan plan = new TrainingPlan();
        plan.addPlanActivity(1);
        assertEquals(plan.getPlanActivities().get(0), 1);
    }

    @Test
    public void removePlanActivity(){
        TrainingPlan plan = new TrainingPlan();
        plan.addPlanActivity(1);
        plan.addPlanActivity(2);
        plan.addPlanActivity(3);
        assertEquals(plan.getPlanActivities(), new ArrayList<Integer>(){{add(1); add(2); add(3);}});
        plan.removePlanActivity(1);
        assertEquals(plan.getPlanActivities(), new ArrayList<Integer>(){{add(2); add(3);}});
    }
}
