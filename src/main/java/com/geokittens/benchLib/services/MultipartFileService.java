package com.geokittens.benchLib.services;

import org.springframework.web.multipart.MultipartFile;

public interface MultipartFileService {
    MultipartFile buildFromPhoto(byte[] bytes);
}
