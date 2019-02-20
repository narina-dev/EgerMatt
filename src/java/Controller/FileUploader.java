/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;

/**
 *
 * @author Athena
 */
public class FileUploader {
    public static String processFile(String path, FileItemStream item){
        String filename = null;
       try{
        File f = new File(path+File.separator+"images");
        if(!f.exists())f.mkdir ();
        File savedFile = new File(f.getAbsolutePath()+ File.separator+item.getName());
        filename=savedFile.getName();
        FileOutputStream fos = new FileOutputStream(savedFile);
        InputStream is = item.openStream();
        int x  = 0;
        byte[] b = new byte[1024];
        while((x=is.read(b)) != -1){
            fos.write(b , 0 , x);
        }
        fos.flush();
        fos.close();
        
       }catch(Exception e){
           e.printStackTrace();
       }
       
       
        return filename;
    }
}
