package com.poddemo.controllers;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
public class PodDemoController {
    private static final Logger logger = LoggerFactory.getLogger(PodDemoController.class);

    private static final int VERSION = 1;

    @Value( "${value}" )
    private String value;

    @Value("${datasource.url}")
    private String datasourceUrl;

    @Value("${datasource.username}")
    private String datasourceUsername;

    @Value("${datasource.password}")
    private String datasourcePassword;


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

    @GetMapping("/database-hostname")
    public String database(){
        String values = "";
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    datasourceUrl,datasourceUsername,datasourcePassword);

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show variables where Variable_name like '%hostname%';");
            while(rs.next())
                values = rs.getString("Variable_name") + " - " + rs.getString("Value");
                System.out.println(values);
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return values;
    }

    private void logMethodCalled() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        logger.info("Calling {}", methodName);
    }

}
