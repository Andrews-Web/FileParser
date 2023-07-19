package com.eviro.assessment.grad001.andrewowens;

import java.net.URI;
import org.springframework.data.annotation.Id;

public record model(@Id Integer id, String Name, String Surname,String image) {
    
}
