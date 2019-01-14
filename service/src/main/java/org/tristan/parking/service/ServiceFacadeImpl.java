/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tristan.parking.service;

import java.util.List;
import org.tristan.parking.model.Entity;
import org.tristan.parking.model.ServiceFacade;
import org.tristan.parking.model.TicketMachine;

/**
 *
 * @author cgallen
 */
public class ServiceFacadeImpl implements ServiceFacade {
    
    TicketMachine entityDAO = null;

    public void setEntityDAO(TicketMachine entityDAO) {
        this.entityDAO = entityDAO;
    }
/*
    @Override
    public void deleteAllEntities() {
       entityDAO.deleteAllEntities();
    }

    @Override
    public Entity createEntity(Entity entity) {
        return entityDAO.createEntity(entity);
    }

    @Override
    public boolean deleteEntity(Integer id) {
        return entityDAO.deleteEntity(id);
    }

    @Override
    public Entity retrieveEntity(Integer id) {
        return entityDAO.retrieveEntity(id);
    }

    @Override
    public List<Entity> retrieveAllEntities() {
        return entityDAO.retrieveAllEntities();
    }

    @Override
    public List<Entity> retrieveMatchingEntities(Entity entityTempate) {
        return entityDAO.retrieveMatchingEntities(entityTempate);
    }

    @Override
    public Entity updateEntity(Entity entity) {
        return entityDAO.updateEntity(entity);
    }
  */  

    @Override
    public Boolean createTicketMachine(Integer machineId, String location, Boolean stayType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteTicketMachine(Integer machineId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateTicketMachine(Integer machineId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer setSchedule(Integer machineId, Integer scheduleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
