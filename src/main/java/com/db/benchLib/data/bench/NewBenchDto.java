package com.db.benchLib.data.bench;

import com.db.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@AllArgsConstructor
@SuperBuilder
public class NewBenchDto {
    private PointGeo geometry;
    private Map<String, String> properties;
}
