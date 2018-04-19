package main.com.dealer.util;

import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (String) session.getAttribute("userId");
        else
            return null;
    }

    public static void setUserId(String userId) {
        HttpSession session = getSession();
        session.setAttribute("userId", userId);
    }

    public static String convertUploadedFile(UploadedFile uploadedFile) {

        File destFile = new File("out.temp");
        try {
            FileUtils.copyInputStreamToFile(uploadedFile.getInputstream(), destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = destFile.getAbsolutePath();
        return path;
    }

}
