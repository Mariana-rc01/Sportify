package com.group11.sportify.users;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmateurUserTest {
    @Test
    void testName() {
        
    }

    @BeforeAll
    static void beforeClass() {
        
    }

    @BeforeEach
    void setUp() {
        
    }

    @AfterEach
    void tearDown() {
        
    }

    @AfterAll
    static void afterClass() {
        
    }

    @Test
    public void testAmateurConstructor(){
        User user1 = new Amateur();
        assertTrue(user1 != null);
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertTrue(user1 != null);
        User user2 = new Amateur(user1);
        assertTrue(user1.equals(user2));
    }

    @Test
    public void testGetCode(){
        User user1 = new Amateur();
        assertEquals(0, user1.getCode());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(1, user1.getCode());
    }

    @Test
    public void testSetCode(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(1, user1.getCode());
        user1.setCode(10);
        assertEquals(10, user1.getCode());
    }

    @Test
    public void testGetName(){
        User user1 = new Amateur();
        assertEquals("", user1.getName());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("Leonor", user1.getName());
    }

    @Test
    public void testSetName(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("Leonor", user1.getName());
        user1.setName("Joana");
        assertEquals("Joana", user1.getName());
    }

    @Test
    public void testGetAdress(){
        User user1 = new Amateur();
        assertEquals("", user1.getAddress());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("Rua 123", user1.getAddress());
    }

    @Test
    public void testSetAdress(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("Rua 123", user1.getAddress());
        user1.setName("Rua 321");
        assertEquals("Rua 321", user1.getName());
    }

    @Test
    public void testGetEmail(){
        User user1 = new Amateur();
        assertEquals("", user1.getEmail());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("leonor23@gmail.com", user1.getEmail());
    }

    @Test
    public void testSetEmail(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals("leonor23@gmail.com", user1.getEmail());
        user1.setEmail("leonor23@gmail.pt");
        assertEquals("leonor23@gmail.pt", user1.getEmail());
    }

    @Test
    public void testGetAverageHeartRate(){
        User user1 = new Amateur();
        assertEquals(0, user1.getAverageHeartRate());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(80, user1.getAverageHeartRate());
    }

    @Test
    public void testSetAverageHeartRate(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(80, user1.getAverageHeartRate());
        user1.setAverageHeartRate(100);
        assertEquals(100, user1.getAverageHeartRate());
    }

    
    @Test
    public void testGetWeight(){
        User user1 = new Amateur();
        assertEquals(0, user1.getWeight());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(56, user1.getWeight());
    }

    @Test
    public void testSetWeight(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(56, user1.getWeight());
        user1.setWeight(55);
        assertEquals(55, user1.getWeight());
    }

    @Test
    public void testGetHeight(){
        User user1 = new Amateur();
        assertEquals(0, user1.getHeight());
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(160, user1.getHeight());
    }

    @Test
    public void testSetHeight(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(160, user1.getHeight());
        user1.setHeight(165);
        assertEquals(165, user1.getHeight());
    }

    @Test
    public void testGetActivities(){
        User user1 = new Amateur();
        user1.addActivity(1);

        List<Integer> activities = new ArrayList<>();
        activities.add(1);

        assertEquals(activities, user1.getActivities());
        
        List<Integer> activities1 = new ArrayList<>();
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(activities1, user1.getActivities());
    }

    @Test
    public void testGetTrainingPlans(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        user1.addTrainingPlan(1);

        List<Integer> trainigPlans = new ArrayList<>();
        trainigPlans.add(1);

        assertEquals(trainigPlans, user1.getTrainingPlans());
        
        List<Integer> trainigPlans1 = new ArrayList<>();
        user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        assertEquals(trainigPlans1, user1.getActivities());
    }

    @Test
    public void testCalculateBMI(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        double bmi = 56 / (1.60*1.60);
        double roundedBMI = Math.round(bmi * 1000.0) / 1000.0;
        assertEquals(roundedBMI, user1.calculateBMI());
    }

    @Test
    public void testCalculateCaloriesFactor(){
        User user1 = new Amateur(1, "Leonor","Rua 123", "leonor23@gmail.com",80,56,160);
        double factor = 1.2;
        assertEquals(factor, user1.calculateCaloriesFactor());
    }
}
