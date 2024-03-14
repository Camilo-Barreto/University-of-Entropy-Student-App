package com.example.a31008527_springcoursework.RecyclerviewItems;

public class itemTimetableModule {
    String module, location, startTime, endTime, startEndTime;

    public itemTimetableModule(String module, String location, String startTime, String endTime) {
        this.module = module;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startEndTime = startTime + " - " + endTime;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(String startEndTime) {
        this.startEndTime = startEndTime;
    }
}
