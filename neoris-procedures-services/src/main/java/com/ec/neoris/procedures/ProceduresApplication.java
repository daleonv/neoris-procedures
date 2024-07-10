package com.ec.neoris.procedures;

import com.ec.neoris.procedures.config.BaseProcedureConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Neoris procedures Application
 *
 * @author daleonv
 * @version 1.0
 */

@Import({BaseProcedureConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.ec.neoris"})
@ComponentScan(basePackages = {"com.ec.neoris"})
public class ProceduresApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ProceduresApplication.class);
    }

}
