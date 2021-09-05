package com.db.benchLib.data.request;

import com.db.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.bson.types.Binary;

import java.util.Map;

@Data
@AllArgsConstructor
@SuperBuilder
public class NewRequestDto {
    private PointGeo location;
    private Map<String, String> properties;
}
