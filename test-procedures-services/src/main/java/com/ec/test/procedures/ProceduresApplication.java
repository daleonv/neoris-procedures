package com.ec.test.procedures;

import com.ec.test.procedures.config.BaseProcedureConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Test procedures Application
 *
 * @author daleonv
 * @version 1.0
 */

@Import({BaseProcedureConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.ec.test"})
@ComponentScan(basePackages = {"com.ec.test"})
public class ProceduresApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ProceduresApplication.class);
    }

}
