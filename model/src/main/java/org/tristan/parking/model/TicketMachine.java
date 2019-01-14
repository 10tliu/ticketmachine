package org.tristan.parking.model;

import java.util.List;

public class TicketMachine {

    private Integer machineId;

    private String location;
    
    private Boolean stayType;
    
    private ScheduleList scheduleList;
    
    
    //initialise the list by default (constructor)
    public TicketMachine(){
        scheduleList=new ScheduleList();
    }
    
    //constructor
    public TicketMachine(Integer machineId, String location, Boolean stayType, ScheduleList scheduleList){
        this.machineId = machineId;
        this.location = location;
        this.stayType = stayType;
        this.scheduleList = scheduleList;
    }

    //log message
    @Override
    public String toString() {
        return "ReplyMessage{" + "machineId=" + machineId + ", location" + location + ", stayType" + stayType + ", scheduleList=" + scheduleList + '}';
    }

    /**
     * @return the machineId
     */
    public Integer getMachineId() {
        return machineId;
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the stayType
     */
    public Boolean getStayType() {
        return stayType;
    }

    /**
     * @param stayType the stayType to set
     */
    public void setStayType(Boolean stayType) {
        this.stayType = stayType;
    }

    /**
     * @return the scheduleList
     */
    public ScheduleList getScheduleList() {
        return scheduleList;
    }

    /**
     * @param scheduleList the scheduleList to set
     */
    public void setScheduleList(ScheduleList scheduleList) {
        this.scheduleList = scheduleList;
    }

    
    
}
