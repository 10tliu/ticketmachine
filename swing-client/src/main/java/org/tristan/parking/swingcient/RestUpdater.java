/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tristan.parking.swingcient;

import org.tristan.parking.model.TicketMachine;

/**
 *
 * @author cgallen
 */
public class RestUpdater {
    TicketMachine entityDAO = null;
    String updatechron ="";
    String baseUrl = "";
    
    public TicketMachine getEntityDAO() {
        return entityDAO;
    }

    public void setEntityDAO(TicketMachine entityDAO) {
        this.entityDAO = entityDAO;
    }

    public String getUpdatechron() {
        return updatechron;
    }

    public void setUpdatechron(String updatechron) {
        this.updatechron = updatechron;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    public boolean immediateUpdate(){
        return false;
    }
            
}
