package com.db.benchLib.clients;

import com.db.benchLib.data.bench.Bench;
import com.db.benchLib.data.bench.BenchDto;
import com.db.benchLib.data.bench.BenchesNearResponse;
import com.db.benchLib.data.bench.NewBenchDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public interface BenchesServiceClient {

    @RequestLine("GET /{id}")
    BenchDto findBenchById(@Param("id") String id);

    @RequestLine("GET /{id}/photo")
    byte[] getBenchPhoto(@Param("id") String id);

    @RequestLine("GET /find?lat={lat}&lon={lon}&radius={radius}&page={page}&pageSize={pageSize}")
    BenchesNearResponse findBenchesNear(@Param("lon") double lon, @Param("lat") double lat,
                                        @Param("radius") double radius, @Param("page") int page,
                                        @Param("pageSize") int pageSize);

    @Headers({
        "Content-Type: " + MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @RequestLine("POST")
    String addBench(@Param("photo") MultipartFile photo, @Param("bench") NewBenchDto bench);

}
