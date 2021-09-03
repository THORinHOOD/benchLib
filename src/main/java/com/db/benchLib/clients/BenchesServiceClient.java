package com.db.benchLib.clients;

import com.db.benchLib.data.Bench;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BenchesServiceClient {

    @RequestLine("GET /{id}")
    Bench findBenchById(@Param("isbn") String id);

    @RequestLine("GET /find")
    List<Bench> findBenchesNear(@RequestParam double lon, @RequestParam double lat, @RequestParam double radius);

}
