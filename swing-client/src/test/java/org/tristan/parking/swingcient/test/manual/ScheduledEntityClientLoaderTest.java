/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tristan.parking.swingcient.test.manual;

import java.io.File;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tristan.parking.dao.jaxbimpl.EntityDAOJaxbImpl;
import org.tristan.parking.model.Entity;
import org.tristan.parking.swingcient.EntityClientLoader;
import org.tristan.parking.model.TicketMachine;

/**
 *
 * @author cgallen
 */
public class ScheduledEntityClientLoaderTest {

    private static final Logger LOG = LoggerFactory.getLogger(EntitySingleClientLoaderTest.class);

    public static final String TEST_DATA_FILE_LOCATION = "target/testDaofile.xml";

    public static final String TEST_BASE_URL = "http://localhost:8680/";
/*
    @Test
    public void testScheduledClientLoader() {

        // delete test file at start of test
        File file = new File(TEST_DATA_FILE_LOCATION);
        file.delete();
        assertFalse(file.exists());

        // create dao
        TicketMachine entityDAO = new EntityDAOJaxbImpl(TEST_DATA_FILE_LOCATION);
        assertTrue(file.exists());

        EntityClientLoader entityClientLoader = new EntityClientLoader(entityDAO, TEST_BASE_URL);

        // schedule loading every minute (2 retrys interval 10 seconds every minute)
        int scheduleIntervalSeconds = 1 * 60; // 1 minutes
        int retryAttempts = 2;
        int retryIntervalSeconds = 10;
        entityClientLoader.scheduleLoadData(scheduleIntervalSeconds, retryAttempts, retryIntervalSeconds);

        
        try {
            // wait for 5 minutes before ending test
            Thread.sleep(1000 * scheduleIntervalSeconds * 5);
            
            //wait for 30 seconds before ending test
            //Thread.sleep(1000 * 30);
        } catch (InterruptedException ex) {
            LOG.debug("retrieving data interrupted");
        }
        
        entityClientLoader.cancelLoadDataSchedule();

        LOG.debug("Total Client Retrieve Tries = " + entityClientLoader.getTotalClientRetrieveTries());
        LOG.debug("Total Client Retrieve Successful = " + entityClientLoader.getTotalClientRetrieveSuccessful());

        List<Entity> list = entityDAO.retrieveAllEntities();
        LOG.debug("Schedule retrieved entites = " + list.size());

    }
*/
}
