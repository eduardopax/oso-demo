package com.poddemo.controllers;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.InetAddress;

@RestController
public class PodDemoController {
    private static final Logger logger = LoggerFactory.getLogger(PodDemoController.class);

    private static final int VERSION = 1;

    @Value( "${value}" )
    private String value;


    @GetMapping("/load/memory")
    public String getInMemory(){
        logMethodCalled();

        return "Value from memory : [ " + value + " ] ";
    }

    @GetMapping("/load/file")
    public String getFile() throws Exception {
        logMethodCalled();

        File file = new File("/config/application.properties");
        String data = FileUtils.readFileToString(file, "UTF-8");

        return "Value from the file : [ \n" + data + "\n ] ";
    }

    @GetMapping("/hostname")
    public String getHostname(){
        logMethodCalled();
        try {
            return "Hostname: [" + InetAddress.getLocalHost().getHostName() + "]";
        } catch (Exception ex) {
            return "ERROR";
        }

    }

    @GetMapping("/version")
    public String getVersion(){
        logMethodCalled();
        return "Version: [ " + VERSION + " ] ";
    }

    private void logMethodCalled() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Calling {}", methodName);
    }

}
