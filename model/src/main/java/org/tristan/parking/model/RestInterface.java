package org.tristan.parking.model;

public interface RestInterface {

   // public ReplyMessage retrieveMatchingSchedule(Schedule scheduleTemplate);

   // public ReplyMessage retrieveSchedule(Integer id);
    
    public ReplyMessage retrieveMatchingEntites(Entity entityTempate);
    
    public ReplyMessage retrieveEntity(Integer id);
    

}
