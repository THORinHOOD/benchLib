package com.geokittens.benchLib.data.bench;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@SuperBuilder
public class BenchesNearResponse {

    private final List<BenchInfoWithDistance> benches;
    private final int page;
    private final int pageSize;
    private final int pagesCount;
    private final int benchesCount;
    private final double radius;
    private final double lat;
    private final double lon;

}
