package com.db.benchLib.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bench implements Serializable {

    @Id
    private String id;

    private PointGeo geometry;
    private Map<String, String> properties;

}

