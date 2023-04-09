package com.example.fileuploading.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="/Users/SA20408505/Documents/java backend+angular /fileuploading/src/main/resources/static/images";

    public boolean uploadFile(MultipartFile file){
        boolean uploaded=false;
        try{
            InputStream inputStream=file.getInputStream();
            byte data[]=new byte[inputStream.available()];
            inputStream.read(data);
            OutputStream outputStream=new FileOutputStream(UPLOAD_DIR+"/"+file.getOriginalFilename());
            outputStream.write(data);
            outputStream.close();
            outputStream.flush();
            uploaded=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return uploaded;
    }

}
