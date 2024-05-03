package com.group11.sportify.activities.repeating.weight;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import com.group11.sportify.activities.repeating.weight.ActivityRepetitionsWeight;
import com.group11.sportify.activities.repeating.weight.LegExtensionActivityTest;
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

public class LegExtensionActivityTest {
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
    public void testLegExtensionConstructor(){
        Activity activity1 = new LegExtension();
        assertTrue(activity1 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity1 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertTrue(activity1 != null);
    }

    @Test
    public void testLegExtensionGetCode(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals(1, activity2.getCode());
    }

    @Test
    public void testSetCode(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        activity2.setCode(10);
        assertEquals(10, activity2.getCode());
    }

    @Test
    public void testLegExtensionGetDescription(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals("Leg Extension", activity2.getDescription());
    }

    @Test
    public void testSetDescription(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        activity2.setDescription("Hello");
        assertEquals("Hello", activity2.getDescription());
    }

    @Test
    public void testLegExtensionGetTimeSpentMinutes(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals(60, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testSetTimeSpentMinutes(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        activity2.setTimeSpentMinutes(10);
        assertEquals(10, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testLegExtensionGetDate(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testSetDate(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2.setDate(date);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testLegExtensionGetAverageHeartRateDuringActivity(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals(90, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testLegExtensionSetAverageHeartRateDuringActivity(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        activity2.setAverageHeartRateDuringActivity(10);
        assertEquals(10, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testLegExtensionGetWeight(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityRepetitionsWeight) activity2).getWeight());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60,90,date,20,50,1);
        assertEquals(50, ((ActivityRepetitionsWeight) activity2).getWeight());
    }

    @Test
    public void testSetWeight(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityRepetitionsWeight) activity2).getWeight());
        ((ActivityRepetitionsWeight) activity2).setWeight(20);
        assertEquals(20, ((ActivityRepetitionsWeight) activity2).getWeight());
    }

    @Test
    public void testLegExtensionGetUserCode(){
        Activity activity2 = new LegExtension();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getUserCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        assertEquals(1, activity2.getUserCode());
    }

    @Test
    public void testLegExtensionCalculateCaloriesConsume(){
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        Activity activity2 = new LegExtension(1, "Leg Extension",60, 90,date,20,50,1);
        User user1 = new Amateur(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertTrue(activity2 != null);
        assertEquals(17.4,activity2.calculateCaloriesConsume(user1));
        User user2 = new Casual(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(11.600000000000001,activity2.calculateCaloriesConsume(user2));
        User user3 = new Professional(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(20.299999999999997,activity2.calculateCaloriesConsume(user3));
    }
}