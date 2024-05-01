package com.group11.sportify.activities.repeating;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.Amateur;
import com.group11.sportify.users.Casual;
import com.group11.sportify.users.Professional;
import com.group11.sportify.users.User;

public class StretchActivityTest {
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
    public void testStretchConstructor(){
        Activity activity1 = new Stretch();
        assertTrue(activity1 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity1 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertTrue(activity1 != null);
        Activity activity2 = new Stretch((ActivityRepetitions)activity1);
        assertFalse(activity1.equals(activity2));
    }

    @Test
    public void testStretchGetCode(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(1, activity2.getCode());
    }

    @Test
    public void testSetCode(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        activity2.setCode(10);
        assertEquals(10, activity2.getCode());
    }

    @Test
    public void testStretchGetDescription(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals("Stretch", activity2.getDescription());
    }

    @Test
    public void testSetDescription(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        activity2.setDescription("Ola");
        assertEquals("Ola", activity2.getDescription());
    }

    @Test
    public void testStretchGetTimeSpentMinutes(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(100, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testSetTimeSpentMinutes(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        activity2.setTimeSpentMinutes(10);
        assertEquals(10, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testStretchGetDate(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testSetDate(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2.setDate(date);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testStretchGetAverageHeartRateDuringActivity(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(100, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testStretchSetAverageHeartRateDuringActivity(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        activity2.setAverageHeartRateDuringActivity(10);
        assertEquals(10, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testStretchGetRepetitions(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityRepetitions) activity2).getRepetitions());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(10, ((ActivityRepetitions) activity2).getRepetitions());
    }

    @Test
    public void testSetRepetitions(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityRepetitions) activity2).getRepetitions());
        ((ActivityRepetitions) activity2).setRepetitions(10);
        assertEquals(10, ((ActivityRepetitions) activity2).getRepetitions());
    }

    @Test
    public void testStretchGetUserCode(){
        Activity activity2 = new Stretch();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getUserCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        assertEquals(1, activity2.getUserCode());
    }

    @Test
    public void testStretchCalculateCaloriesConsume(){
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        Activity activity2 = new Stretch(1, "Stretch",100, 100,date,10,1);
        User user1 = new Amateur(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertTrue(activity2 != null);
        assertEquals(1.2,activity2.calculateCaloriesConsume(user1));
        User user2 = new Casual(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(0.8,activity2.calculateCaloriesConsume(user2));
        User user3 = new Professional(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(1.4,activity2.calculateCaloriesConsume(user3));
    }
}
