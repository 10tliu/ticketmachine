package org.tristan.parking.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScheduleList {

    private Integer lastTicketId = null;

    @XmlElementWrapper(name = "entities")
    @XmlElement(name = "entity")
    private List<Schedule> schedules;

    
    public ScheduleList()
    {
        schedules = new ArrayList<Schedule>();
    }
    
    /**
     * @return the lastTicketId
     */
    //getter
    public Integer getLastTicketId() {
        return lastTicketId;
    }

    /**
     * @param lastEntityId the lastEntityId to set
     */
    //setter
    public void setLastTicketId(Integer lastTicketId) {
        this.lastTicketId = lastTicketId;
    }

    /**
     * @return the schedules
     */
    public List<Schedule> getSchedules() {
        return schedules;
    }

    /**
     * @param schedules the schedules to set
     */
    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
