package org.software.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


public class StudentController {

        JdbcTemplate template;
        public JdbcTemplate config(){
            try {
                DriverManagerDataSource driver = new DriverManagerDataSource();
                driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
                driver.setUrl("jdbc:mysql://localhost:3306/allstudentdetails");
                driver.setUsername("root");
                driver.setPassword("");
                template = new JdbcTemplate();
                template.setDataSource(driver);

            }catch(Exception e){
                System.out.println("Exception Occur in the StudentController config method::"+e);
            }
            return template;

        }
}
