package com.eviro.assessment.grad001.andrewowens;

import java.io.File;
import java.net.URI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AndrewApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndrewApplication.class, args);
	}
        
        @Bean
        CommandLineRunner commandLineRunner(Repository repo){
            
            Image obj = new Image();
            
            File csvFile = new File("File.csv");
            obj.parseCSV(csvFile);
            String name = obj.getName();
            String Surname = obj.getSurame();
            File image = obj.convertCSVDataToImage(obj.getImage());
            URI imageLink = obj.createImageLink(image);
            
            return args -> {
            repo.save(new model(null,name,Surname,imageLink.toString()));
            };
        }    
}
