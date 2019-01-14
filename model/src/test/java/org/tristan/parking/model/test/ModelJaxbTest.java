/* ***************************************************************************
 * Copyright 2018 Craig Gallen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ****************************************************************************/
package org.tristan.parking.model.test;

import java.io.File;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;
import static org.junit.Assert.*;
import org.tristan.parking.model.Entity;
import org.tristan.parking.model.ReplyMessage;
import org.tristan.parking.model.Schedule;
import org.tristan.parking.model.TicketMachine;

/**
 *
 * @author gallenc
 */
public class ModelJaxbTest {

    
    @Test
    public void retrieve_Tickets_From_Database() {

        try {

            // test file we will write and read. 
            // Note in target so that will be delted on each run and will not be saved to git
            File file = new File("target/testTicketSystemData1.xml");
            System.out.println("writing test file to " + file.getAbsolutePath());

            // jaxb context needs jaxb.index file to be in same classpath
            // this contains a list of Jaxb annotated classes for the context to parse
            JAXBContext jaxbContext = JAXBContext.newInstance("org.tristan.parking.model");

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // create some mock objects to test marshalling and unmarshalling
            TicketMachine ticket = new TicketMachine();
            //ticket.setLocation("Manchester");
            //ticket.setMachineId(1);
            //ticket.setStayType(Boolean.TRUE);
            
            //getting all schedules in ticket class
            //List<Schedule> schedules = ticket.getScheduleList().getSchedules();

            /*for (int i = 0; i < 3; i++) {
                //initialising the object (reserving memory)
                Schedule schedule = new Schedule();
                schedule.setScheduleID(i);
                Date startdate  =new Date();
                schedule.setStartTime(startdate);
                schedule.setHourlyRate(2.0);;
                schedules.add(schedule);
            }*/

            // marshal the object lists to system out, a file and a stringWriter
            jaxbMarshaller.marshal(ticket, System.out);
            jaxbMarshaller.marshal(ticket, file);

            // string writer is used to compare received object
            StringWriter sw1 = new StringWriter();
            jaxbMarshaller.marshal(ticket, sw1);

            // having written the file we now read in the file for test
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            TicketMachine ticket1 = (TicketMachine) jaxbUnMarshaller.unmarshal(file);

            StringWriter sw2 = new StringWriter();
            jaxbMarshaller.marshal(ticket1, sw2);

            // check transmitted and recieved message are the same
            assertEquals(sw1.toString(), sw2.toString());

        } catch (JAXBException e) {
            String error = e.getMessage();
            throw new RuntimeException("problem testing jaxb marshalling", e);
        }
    }

}
