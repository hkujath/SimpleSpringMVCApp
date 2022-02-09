package de.hkujath.simplespringmvcapp.config;

import de.hkujath.simplespringmvcapp.SimpleSpringMvcAppApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(SimpleSpringMvcAppApplication.class);
   }

}
