package com.geokittens.benchLib.clients;

import com.geokittens.benchLib.data.request.NewRequestDto;
import com.geokittens.benchLib.data.request.RequestDto;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.multipart.MultipartFile;

public interface RequestsServiceClient {

    @RequestLine("POST")
    String addRequest(@Param("photo") MultipartFile photo, @Param("request") NewRequestDto request);

    @RequestLine("GET /{id}")
    RequestDto getRequest(@Param("id") String id);

    @RequestLine("GET /{id}/photo")
    byte[] getRequestPhoto(@Param("id") String id);

}
