package com.eviro.assessment.grad001.andrewowens;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Base64;
import java.util.Scanner;

public class Image implements FileParser {   
    private File file;
    private String Name;
    private String Surname;
    private String image;
    
    
    public String getName(){
        return Name;
    }
    
    public String getSurame(){
        return Surname;
    }
    
    public String getImage(){
        return image;
    }
    
    public void GetData() {
        String strfile;
        strfile = file.toString();
        String[] arrSent;
        String input = "";
        
        Scanner scan = new Scanner(strfile);
        scan.useDelimiter(",");
        
        while (scan.hasNext()){
            input += scan.next();
        }
        
        arrSent = input.split(",");
        
        scan.close();
        try{
            this.Name = arrSent[4];
            this.Surname = arrSent[5];
            this.image = arrSent[7];   
        }catch(Exception ex){
             System.out.print(ex);
        }
    }

    public void parseCSV(File csvFile) {
        this.file = csvFile;
        GetData();
    }

    public File convertCSVDataToImage(String base64ImageData) {
        String[] strings = base64ImageData.split(",");
        String extension = "jpeg";
        
        //convert base64 string to binary data
        byte[] data = Base64.getDecoder().decode(base64ImageData);
        File path = new File("image." + extension);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return path;
    }

    public URI createImageLink(File fileImage) {
        return fileImage.toURI();
    }
    
}
