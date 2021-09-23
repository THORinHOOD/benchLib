package com.geokittens.benchLib.data.bench;

import com.geokittens.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Bench implements Serializable {
    @Id
    private String id;
    private PointGeo geometry;
    private Map<String, String> properties;
    private Binary photo;

    public BenchDto toDto() {
        return BenchDto.builder()
                .geometry(geometry)
                .id(id)
                .properties(properties)
                .build();
    }
}

