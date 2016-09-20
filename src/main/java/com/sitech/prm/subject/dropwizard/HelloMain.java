package com.sitech.prm.subject.dropwizard;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class HelloMain extends Service {
   public static void main(String[] args) throws Exception {
	   System.out.println(args[0]);
       new HelloMain().run(args);
   }

    @Override
   public void initialize(Bootstrap bootstrap) {
   }

    @Override
   public void run(Configuration configuration, Environment environment) throws Exception {
       environment.addResource(new HelloResource());
   }
}