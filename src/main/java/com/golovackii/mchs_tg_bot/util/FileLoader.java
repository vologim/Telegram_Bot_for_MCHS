package com.golovackii.mchs_tg_bot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileLoader {

    @Value("${file.path}")
    private String filePath;

    public String uploadFile(String path, MultipartFile multipartFile) {

        String pathFolder = filePath + path;

        try {
            Files.createDirectories(Paths.get(pathFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileAddress = pathFolder + "/" + multipartFile.getOriginalFilename();

        File file = new File(fileAddress);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            byte[] bytes = multipartFile.getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileAddress;
    }
}