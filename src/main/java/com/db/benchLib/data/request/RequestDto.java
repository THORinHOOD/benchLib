package com.db.benchLib.data.request;

import com.db.benchLib.data.PointGeo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@AllArgsConstructor
@SuperBuilder
public class RequestDto {
    private String id;
    private PointGeo location;
    private Map<String, String> properties;
    private RequestStatus requestStatus;
    private String benchId;
}
