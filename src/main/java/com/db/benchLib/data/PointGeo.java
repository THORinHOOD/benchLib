package com.db.benchLib.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointGeo implements Serializable {
    private String type;
    private List<Double> coordinates;
}