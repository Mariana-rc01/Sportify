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

public class RoadCyclingActivityTest {
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
    public void testRoadCyclingConstructor(){
        Activity activity1 = new RoadCycling();
        assertTrue(activity1 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity1 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertTrue(activity1 != null);
    }

    @Test
    public void testRoadCyclingGetCode(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals(1, activity2.getCode());
    }

    @Test
    public void testSetCode(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        activity2.setCode(10);
        assertEquals(10, activity2.getCode());
    }

    @Test
    public void testRoadCyclingGetDescription(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals("Road Cycling", activity2.getDescription());
    }

    @Test
    public void testSetDescription(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals("", activity2.getDescription());
        activity2.setDescription("Hello");
        assertEquals("Hello", activity2.getDescription());
    }

    @Test
    public void testRoadCyclingGetTimeSpentMinutes(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals(60, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testSetTimeSpentMinutes(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getTimeSpentMinutes());
        activity2.setTimeSpentMinutes(10);
        assertEquals(10, activity2.getTimeSpentMinutes());
    }

    @Test
    public void testRoadCyclingGetDate(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testSetDate(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2.setDate(date);
        assertEquals(date, activity2.getDate());
    }

    @Test
    public void testRoadCyclingGetAverageHeartRateDuringActivity(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals(90, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testRoadCyclingSetAverageHeartRateDuringActivity(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getAverageHeartRateDuringActivity());
        activity2.setAverageHeartRateDuringActivity(10);
        assertEquals(10, activity2.getAverageHeartRateDuringActivity());
    }

    @Test
    public void testRoadCyclingGetAltitude(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistanceAltitude) activity2).getAltitude());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60,90,date,20,5,1);
        assertEquals(5, ((ActivityDistanceAltitude) activity2).getAltitude());
    }

    @Test
    public void testSetAltitude(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, ((ActivityDistanceAltitude) activity2).getAltitude());
        ((ActivityDistanceAltitude) activity2).setAltitude(5);
        assertEquals(5, ((ActivityDistanceAltitude) activity2).getAltitude());
    }

    @Test
    public void testRoadCyclingGetUserCode(){
        Activity activity2 = new RoadCycling();
        assertTrue(activity2 != null);
        assertEquals(0, activity2.getUserCode());
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        assertEquals(1, activity2.getUserCode());
    }

    @Test
    public void testRoadCyclingCalculateCaloriesConsume(){
        LocalDateTime date = LocalDateTime.of(2024, 4, 30, 10, 30, 0);
        Activity activity2 = new RoadCycling(1, "Road Cycling",60, 90,date,20,5,1);
        User user1 = new Amateur(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertTrue(activity2 != null);
        assertEquals(1.7999999999999998,activity2.calculateCaloriesConsume(user1));
        User user2 = new Casual(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(1.2000000000000002,activity2.calculateCaloriesConsume(user2));
        User user3 = new Professional(1, "Raquel","Rua 123", "raquel23@gmail.com",80,56,160);
        assertEquals(2.0999999999999996,activity2.calculateCaloriesConsume(user3));
    }
}
