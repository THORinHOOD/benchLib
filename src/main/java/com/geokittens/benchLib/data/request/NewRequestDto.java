package com.geokittens.benchLib.data.request;

import com.geokittens.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@AllArgsConstructor
@SuperBuilder
public class NewRequestDto {
    private PointGeo location;
    private Map<String, String> properties;
}
