package com.example.xulaundryapp;

import java.util.LinkedList;
import java.util.Queue;

public class LaundryUnit {
    String TAG = "LaundryUnit.java";
    public final String STATUS_OPEN = "OPEN";
    public final String STATUS_IDLE = "IDLE";
    public final String STATUS_RUNNING = "RUNNING";
    public final String STATUS_RESERVED = "RESERVED";
    String id;
    String status;
    boolean unitIsWasher; // true for washer, false for dryer
    String dorm;
    int floor;
    float timeRemaining;
    Queue<User> reservationList;

    public LaundryUnit(String id, boolean unitIsWasher, String dorm, int floor) {
        this.id = id;
        this.unitIsWasher = unitIsWasher;
        this.dorm = dorm;
        this.floor = floor;
        timeRemaining = 0;
        status = STATUS_OPEN;
        reservationList = new LinkedList<>();
    }

    public void addToReservationList(User u) {
        reservationList.add(u);
        if (!this.status.equals(STATUS_RUNNING)) {
            this.setStatus(STATUS_RESERVED);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LaundryUnit{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", unitIsWasher=" + unitIsWasher +
                ", dorm='" + dorm + '\'' +
                ", floor=" + floor +
                ", timeRemaining=" + timeRemaining +
                ", reservationList=" + reservationList +
                '}';
    }
}
