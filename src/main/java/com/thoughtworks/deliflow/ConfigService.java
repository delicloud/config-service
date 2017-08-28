package com.thoughtworks.deliflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableAutoConfiguration
public class ConfigService {

  public static void main(String[] args) {
    SpringApplication.run(ConfigService.class, args);
  }
}
