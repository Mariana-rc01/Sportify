package com.group11.sportify.activities.distance.altitude;

import com.group11.sportify.activities.Activity;
import com.group11.sportify.users.Amateur;
import com.group11.sportify.users.Casual;
import com.group11.sportify.users.Professional;
import com.group11.sportify.users.User;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MountainBikingActivityTest {
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
    public void testMountainBikingConstructor(){
        Activity activity1 = new MountainBiking();
        assertTrue(activity1 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity1 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertTrue(activity1 != null);
    }

    @Test
    public void testMountainBikingGetCode(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals(1, activity2.getCode());
    }

    @Test
    public void testSetCode(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        activity2.setCode(10);
        assertEquals(10, activity2.getCode());
    }

    @Test
    public void testMountainBikingGetDescription(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals("Mountain Biking", activity2.getDescription());
    }

    @Test
    public void testSetDescription(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        activity2.setDescription("Hello");
        assertEquals("Hello", activity2.getDescription());
    }

    @Test
    public void testMountainBikingGetTimeSpentMinutes(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals(60, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testSetTimeSpentMinutes(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        activity2.setTimeSpentMinutes(10);
        assertEquals(10, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testMountainBikingGetDate(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testSetDate(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2.setDate(date);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testMountainBikingGetAverageHeartRateDuringActivity(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals(90, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testMountainBikingSetAverageHeartRateDuringActivity(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        activity2.setAverageHeartRateDuringActivity(10);
        assertEquals(10, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testMountainBikingGetAltitude(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistanceAltitude) activity2).getAltitude());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60,90,date,20,5,1);
        assertEquals(5, ((ActivityDistanceAltitude) activity2).getAltitude());
    }

    @Test
    public void testSetAltitude(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistanceAltitude) activity2).getAltitude());
        ((ActivityDistanceAltitude) activity2).setAltitude(5);
        assertEquals(5, ((ActivityDistanceAltitude) activity2).getAltitude());
    }

    @Test
    public void testMountainBikingGetUserCode(){
        Activity activity2 = new MountainBiking();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getUserCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        assertEquals(1, activity2.getUserCode());
    }

    @Test
    public void testMountainBikingCalculateCaloriesConsume(){
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        Activity activity2 = new MountainBiking(1, "Mountain Biking",60, 90,date,20,5,1);
        User user1 = new Amateur(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertTrue(activity2 != null);
        assertEquals(3.3,activity2.calculateCaloriesConsume(user1));
        User user2 = new Casual(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(2.2,activity2.calculateCaloriesConsume(user2));
        User user3 = new Professional(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(3.8499999999999996,activity2.calculateCaloriesConsume(user3));
    }
}
