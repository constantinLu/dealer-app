package main.com.dealer.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@ManagedBean(name = "uploadBean", eager = true)
@RequestScoped
public class Upload {


    private Part uploadFile;
    private String text;

    public Upload() {

    }

    public void upload() {
        if (uploadFile != null) {
            try {
                InputStream is = uploadFile.getInputStream();
                text = new Scanner(is).useDelimiter("\\A").next();
            } catch (IOException ex) {
                System.out.println("File not found");
            }
        }
    }


    public Part getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Part uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
