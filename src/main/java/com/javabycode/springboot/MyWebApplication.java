package com.javabycode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

@SpringBootApplication
public class MyWebApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        int flag = 0;
        for (NetworkInterface iface : interfaces)
        {
            for (InterfaceAddress addr : iface.getInterfaceAddresses()) 
            {
               if(addr.getAddress().toString().startsWith("/192.168."))
               {
                   flag=1;
                   System.setProperty("server.address", addr.getAddress().toString().substring(1));
                   break;
               }
                if(flag==1)
                {
                    break;
                }
            } 
        }
        
        SpringApplication.run(MyWebApplication.class, args);
    }
}
