package com.example.xulaundryapp;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class LaundryRoom {
    String TAG = "LaundryRoom.java";
    String dormName;
    int floor;
    Map<String, LaundryUnit> laundryUnits;

    public LaundryRoom(String dormName, int floor, Map<String, LaundryUnit> laundryUnits) {
        this.dormName = dormName;
        this.floor = floor;
        this.laundryUnits = laundryUnits;
    }

    public LaundryRoom(String dormName, int floor) {
        this.dormName = dormName;
        this.floor = floor;
        this.laundryUnits = new HashMap<>();
    }

    public void add(String id, boolean unitIsWasher) {
        laundryUnits.put(id,new LaundryUnit(id, unitIsWasher,dormName,floor));
        Log.i(TAG,"Laundry Units:\n" + laundryUnits);
    }

    public LaundryUnit get(String id) {
        return laundryUnits.get(id);
    }

    public String getUnitStatus(String id) {
        return laundryUnits.get(id).getStatus();
    }

    public void reserve(String id, User u) {
        LaundryUnit unit = get(id);
        unit.addToReservationList(u);
        Log.i(TAG, "User " + u + " has been added to the reservation list for unit " + id);
        Log.i(TAG,"Waitlist for " + id + ": " + unit.reservationList);
    }

    @Override
    public String toString() {
        return "LaundryRoom{" +
                "dormName='" + dormName + '\'' +
                ", floor=" + floor +
                ", laundryUnits=" + laundryUnits +
                '}';
    }
}
