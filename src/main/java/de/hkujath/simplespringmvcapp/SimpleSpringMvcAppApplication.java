package de.hkujath.simplespringmvcapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "de.hkujath.simplespringmvcapp")
@Slf4j
public class SimpleSpringMvcAppApplication {

   public static void main(String[] args) {
      SpringApplication.run(SimpleSpringMvcAppApplication.class, args);
   }

   /**
    * Function can be used to print out some information during start.
    * @param ctx
    * @return
    */
   @Bean
   public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
      return args -> {
         LOG.info("Adding default values to books");
      };
   }
}
