package org.tristan.parking.model;

public interface TicketMachineDAO {

    public Boolean createTicketMachine(Integer machineId, String location, Boolean stayType);

    public Integer deleteTicketMachine(Integer machineId);

    public Integer updateTicketMachine(Integer machineId);

    public Integer setSchedule(Integer machineId, Integer scheduleId);
}
