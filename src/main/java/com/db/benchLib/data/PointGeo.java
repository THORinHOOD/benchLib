package com.db.benchLib.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PointGeo implements Serializable {

    public static PointGeo point(List<Double> coordinates) {
        return PointGeo.builder()
                .type("Point")
                .coordinates(coordinates)
                .build();
    }

    private String type;
    private List<Double> coordinates;
}