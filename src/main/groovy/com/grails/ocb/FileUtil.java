package com.grails.ocb;

import grails.util.Holders;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static String getRootPath() {
        ServletContext servletContext = (ServletContext) Holders.getServletContext();
        return servletContext.getRealPath("");
    }

    public static File makeDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String uploadContactImage(Integer contactId, MultipartFile multipartFile) throws IOException {
        if (contactId != null && multipartFile != null) {
            String rootPath = getRootPath();
            String contactImagePath = rootPath + "contact-image/";
            makeDirectory(contactImagePath);
            String originalFileName = multipartFile.getOriginalFilename();
            File destinationFile = new File(contactImagePath, contactId + "-" + originalFileName);
            multipartFile.transferTo(destinationFile);
            return originalFileName;
        }
        return "";
    }
}