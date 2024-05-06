package com.group11.sportify.activities.distance;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.Amateur;
import com.group11.sportify.users.Casual;
import com.group11.sportify.users.Professional;
import com.group11.sportify.users.User;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RowingActivityTest {
    @Test
    public void testRowingConstructor(){
        Activity activity1 = new Rowing();
        assertTrue(activity1 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity1 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertTrue(activity1 != null);
    }

    @Test
    public void testRowingGetCode(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals(1, activity2.getCode());
    }

    @Test
    public void testSetCode(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        activity2.setCode(10);
        assertEquals(10, activity2.getCode());
    }

    @Test
    public void testRowingGetDescription(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals("Rowing", activity2.getDescription());
    }

    @Test
    public void testSetDescription(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        activity2.setDescription("Hello");
        assertEquals("Hello", activity2.getDescription());
    }

    @Test
    public void testRowingGetTimeSpentMinutes(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals(60, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testSetTimeSpentMinutes(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        activity2.setTimeSpentMinutes(10);
        assertEquals(10, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testRowingGetDate(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testSetDate(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2.setDate(date);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testRowingGetAverageHeartRateDuringActivity(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals(90, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testRowingSetAverageHeartRateDuringActivity(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        activity2.setAverageHeartRateDuringActivity(10);
        assertEquals(10, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testRowingGetDistance(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistance) activity2).getDistance());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60,90,date,20,1);
        assertEquals(20, ((ActivityDistance) activity2).getDistance());
    }

    @Test
    public void testSetDistance(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistance) activity2).getDistance());
        ((ActivityDistance) activity2).setDistance(20);
        assertEquals(20, ((ActivityDistance) activity2).getDistance());
    }

    @Test
    public void testRowingGetUserCode(){
        Activity activity2 = new Rowing();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getUserCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        assertEquals(1, activity2.getUserCode());
    }

    @Test
    public void testRowingCalculateCaloriesConsume(){
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        Activity activity2 = new Rowing(1, "Rowing",60, 90,date,20,1);
        User user1 = new Amateur(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertTrue(activity2 != null);
        assertEquals(9,activity2.calculateCaloriesConsume(user1));
        User user2 = new Casual(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(6,activity2.calculateCaloriesConsume(user2));
        User user3 = new Professional(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(10.5,activity2.calculateCaloriesConsume(user3));
    }
}
