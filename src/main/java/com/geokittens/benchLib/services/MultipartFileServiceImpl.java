package com.geokittens.benchLib.services;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MultipartFileServiceImpl implements MultipartFileService {

    @SneakyThrows
    public MultipartFile buildFromPhoto(byte[] bytes) {
        FileItem fileItem = new DiskFileItemFactory().createItem("photo", "image/png",
                false, "photo");
        try (InputStream is = new ByteArrayInputStream(bytes); OutputStream os = fileItem.getOutputStream()) {
            is.transferTo(os);
        }
        return new CommonsMultipartFile(fileItem);
    }

}
