package com.eviro.assessment.grad001.andrewowens;

import java.io.File;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/Andrew")
public class ImageController {

    @GetMapping(value = "/{name}/{surname}/")
    public FileSystemResource gethttpImageLink(@PathVariable String name, @PathVariable String surname) {
        Image obj = new Image();
        File image = obj.convertCSVDataToImage(obj.getImage());
        return new FileSystemResource(image);
        
    }
}