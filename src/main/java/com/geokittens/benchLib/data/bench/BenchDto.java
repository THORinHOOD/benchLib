package com.geokittens.benchLib.data.bench;

import com.geokittens.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BenchDto {
    private String id;
    private PointGeo geometry;
    private Map<String, String> properties;
}
