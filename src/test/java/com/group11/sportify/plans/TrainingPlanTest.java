package com.group11.sportify.plans;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TrainingPlanTest {
    @Test
    public void testTrainingPlanConstructor(){
        TrainingPlan trainingPlan1 = new TrainingPlan();
        assertNotNull(trainingPlan1);
        TrainingPlan trainingPlan2 = new TrainingPlan(LocalDateTime.now());
        assertNotNull(trainingPlan2);
    }

    /*@Test
    public void testGetStartDate(){
        LocalDateTime date = LocalDateTime.now();
        TrainingPlan trainingPlan = new TrainingPlan(date);
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
        plan.addPlanActivity(new PlanActivity(10, 20));
        plan.addPlanActivity(new PlanActivity(5, 7));
        plan.addPlanActivity(new PlanActivity(6, 2));

        assertEquals(plan.getPlanActivities(), new ArrayList<PlanActivity>(){{add(new PlanActivity(10, 20)); add(new PlanActivity(5, 7)); add(new PlanActivity(6, 2));}});
    }

    @Test
    public void testsetPlanActivities(){
        TrainingPlan plan = new TrainingPlan();
        HashMap<Integer, PlanActivity> activities = new HashMap<>();
        activities.put(0, new PlanActivity(10, 20));
        activities.put(1, new PlanActivity(5, 7));
        activities.put(2, new PlanActivity(6, 2));
        plan.setPlanActivities(activities);
        assertEquals(plan.getPlanActivities(), new ArrayList<PlanActivity>(){{add(new PlanActivity(10, 20)); add(new PlanActivity(5, 7)); add(new PlanActivity(6, 2));}});
    }

    @Test
    public void testAddPlanActivity(){
        TrainingPlan plan = new TrainingPlan();
        plan.addPlanActivity(new PlanActivity(10, 20));
        assertEquals(plan.getPlanActivities().get(0), new PlanActivity(10, 20));
    }

    @Test
    public void removePlanActivity(){
        TrainingPlan plan = new TrainingPlan();
        plan.addPlanActivity(new PlanActivity(10, 20));
        plan.addPlanActivity(new PlanActivity(5, 7));
        plan.addPlanActivity(new PlanActivity(6, 2));
        assertEquals(plan.getPlanActivities(), new ArrayList<PlanActivity>(){{add(new PlanActivity(10, 20)); add(new PlanActivity(5, 7)); add(new PlanActivity(6, 2));}});
        plan.removePlanActivity(0);
        assertEquals(plan.getPlanActivities(), new ArrayList<PlanActivity>(){{add(new PlanActivity(5, 7)); add(new PlanActivity(6, 2));}});
    }*/
}
