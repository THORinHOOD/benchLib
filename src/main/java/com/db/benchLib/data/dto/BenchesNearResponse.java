package com.db.benchLib.data.dto;


import com.db.benchLib.data.BenchWithDistance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@SuperBuilder
public class BenchesNearResponse {

    private final List<BenchWithDistance> benches;
    private final int page;
    private final int pageSize;
    private final int pagesCount;
    private final int benchesCount;
    private final double radius;
    private final double lat;
    private final double lon;

}
