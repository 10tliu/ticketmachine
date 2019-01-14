/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tristan.parking.service;

import org.tristan.parking.dao.jaxbimpl.EntityDAOJaxbImpl;
import org.tristan.parking.model.EntityDAO;
import org.tristan.parking.model.ServiceFacade;
import org.tristan.parking.model.ServiceFactory;
import org.tristan.parking.model.TicketMachine;

/**
 *
 * @author cgallen
 */
public class ServiceFactoryImpl implements ServiceFactory {

    ServiceFacade serviceFacade = null;

    String dataFileUri = null;

    public ServiceFactoryImpl(String dataFileUri) {
        if (dataFileUri == null) {
            throw new IllegalArgumentException("dataFileUri must not be null");
        }
        
        //TicketMachine entityDao = new EntityDAOJaxbImpl(dataFileUri);
        EntityDAO entityDao = new EntityDAOJaxbImpl(dataFileUri);
        ServiceFacadeImpl serviceFacadeImpl = new ServiceFacadeImpl();
        //serviceFacadeImpl.setEntityDAO(entityDao);
        serviceFacade = serviceFacadeImpl;
        
    }

    @Override
    public ServiceFacade getServiceFacade() {
        return serviceFacade;
    }

}
