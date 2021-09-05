package com.db.benchLib.clients;

import com.db.benchLib.data.Bench;
import com.db.benchLib.data.dto.BenchesNearResponse;
import feign.Param;
import feign.RequestLine;

public interface BenchesServiceClient {

    @RequestLine("GET /{id}")
    Bench findBenchById(@Param("id") String id);

    @RequestLine("GET /find?lat={lat}&lon={lon}&radius={radius}&page={page}&pageSize={pageSize}")
    BenchesNearResponse findBenchesNear(@Param("lon") double lon, @Param("lat") double lat,
                                        @Param("radius") double radius, @Param("page") int page,
                                        @Param("pageSize") int pageSize);

}
