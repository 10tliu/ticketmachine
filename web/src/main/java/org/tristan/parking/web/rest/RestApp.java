package org.tristan.parking.web.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApp extends ResourceConfig {

    public RestApp() {
        packages("org.tristan.parking.web.rest");
    }
}
